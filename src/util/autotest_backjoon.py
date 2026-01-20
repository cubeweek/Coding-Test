import sys
import os
import re
import shutil  # 폴더 삭제용
import json
import subprocess
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
import time

from bs4 import BeautifulSoup


# 현재 스크립트 위치에서 위로 올라가며 src 폴더가 있는 곳을 찾음
#   (못 찾으면 현재 위치 리턴)
def find_repo_root():
    # current_dir = os.path.dirname(os.path.abspath(__file__))
    current_dir = "./"

    while current_dir != os.path.dirname(current_dir):  # 루트(/)에 도달할 때까지
        if "src" in os.listdir(current_dir):
            return current_dir
        current_dir = os.path.dirname(current_dir)

    return os.path.dirname(os.path.abspath(__file__))


# === 설정 ===
PROBLEM_DIR = find_repo_root()
CACHE_DIR = ".boj_cache"  # 캐시 저장할 폴더


def clear_cache():
    """캐시 폴더 전체 삭제"""
    if os.path.exists(CACHE_DIR):
        try:
            shutil.rmtree(CACHE_DIR)
            print(f"🧹 캐시 폴더({CACHE_DIR})를 깨끗하게 비웠습니다!")
        except Exception as e:
            print(f"❌ 캐시 삭제 실패: {e}")
    else:
        print("💨 삭제할 캐시가 없습니다.")


def get_cached_test_cases(problem_id):
    cache_path = os.path.join(CACHE_DIR, f"{problem_id}.json")
    if os.path.exists(cache_path):
        try:
            with open(cache_path, "r", encoding="utf-8") as f:
                return json.load(f)
        except Exception:
            return None
    return None


def save_test_cases_to_cache(problem_id, data):
    if not os.path.exists(CACHE_DIR):
        os.makedirs(CACHE_DIR)

    cache_path = os.path.join(CACHE_DIR, f"{problem_id}.json")
    with open(cache_path, "w", encoding="utf-8") as f:
        json.dump(data, f, ensure_ascii=False, indent=2)


def fetch_test_cases_from_server(problem_id):
    url = f"https://www.acmicpc.net/problem/{problem_id}"
    print(f"🌍 백준 서버 접속 중 (Selenium)... ({url})")

    # 브라우저 설정 (헤드리스: 창 안 띄우고 백그라운드 실행)
    chrome_options = Options()
    chrome_options.add_argument("--headless")  # 창 보고 싶으면 이 줄 주석 처리
    chrome_options.add_argument("--no-sandbox")
    chrome_options.add_argument("--disable-dev-shm-usage")
    # 봇 탐지 방지용 헤더
    chrome_options.add_argument(
        "user-agent=Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36")

    driver = None
    try:
        # 크롬 드라이버 자동 설치 및 실행
        service = Service(ChromeDriverManager().install())
        driver = webdriver.Chrome(service=service, options=chrome_options)

        driver.get(url)

        # [핵심] Cloudflare 검사 페이지("잠시만 기다려주세요")를 통과하기 위해 잠시 대기
        # 202가 뜨는 이유가 이 대기 시간이 없어서임
        time.sleep(3)

        # 페이지 소스 가져오기
        html = driver.page_source

        # BeautifulSoup으로 파싱 (기존 로직 재사용)
        soup = BeautifulSoup(html, 'html.parser')

        test_cases = []
        i = 1
        while True:
            input_tag = soup.find(id=f'sample-input-{i}')
            output_tag = soup.find(id=f'sample-output-{i}')

            if not input_tag or not output_tag:
                break

            test_cases.append({
                "input": input_tag.text.strip(),
                "output": output_tag.text.strip()
            })
            i += 1

        return test_cases

    except Exception as e:
        raise Exception(f"Selenium 실행 중 오류 발생: {e}")
    finally:
        if driver:
            driver.quit()


def find_kotlin_file(file_name):
    target_name = f"{file_name}.kt"
    for root, dirs, files in os.walk(PROBLEM_DIR):
        if target_name in files:
            return os.path.join(root, target_name)
    return None


def run_kotlin(file_path, input_data):
    # 본인 환경에 맞는 Java 경로 지정 필요시 수정
    # java_path = "/path/to/java"

    jar_name = "temp_solution.jar"
    compile_cmd = ["kotlinc", file_path, "-include-runtime", "-d", jar_name]

    try:
        subprocess.run(compile_cmd, check=True, stderr=subprocess.PIPE)
    except subprocess.CalledProcessError as e:
        return "", f"컴파일 에러:\n{e.stderr.decode('utf-8')}"

    run_cmd = ["java", "-jar", jar_name]
    process = subprocess.Popen(
        run_cmd,
        stdin=subprocess.PIPE,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE,
        text=True
    )

    stdout, stderr = process.communicate(input=input_data)

    if os.path.exists(jar_name):
        os.remove(jar_name)

    return stdout.strip(), stderr


def main():
    if len(sys.argv) < 2:
        print("사용법:")
        print("  python3 autotest.py [파일명]  : 테스트 실행")
        print("  python3 autotest.py clear   : 캐시 삭제")
        return

    command = sys.argv[1]

    # 캐시 삭제
    if command == "clear":
        clear_cache()
        return

    # 숫자만 들어오면 문제 번호로 인식
    match = re.search(r'\d+', command)

    if not match:
        print("⚠️ 문제 번호를 찾을 수 없어 원본 문자열을 사용합니다.")
        return

    problem_id = match.group()

    # 1. 코틀린 파일 찾기
    kt_file = find_kotlin_file(command)
    if not kt_file:
        print(f"❌ 소스 파일을 찾을 수 없습니다: {command}.kt")
        return
    print(f"📂 소스 파일: {kt_file}")

    # 2. 테스트 케이스 확보
    test_cases = get_cached_test_cases(problem_id)

    if test_cases:
        print("⚡ 캐시된 예제를 사용합니다.")
    else:
        try:
            test_cases = fetch_test_cases_from_server(problem_id)
            if not test_cases:
                print("❌ 예제를 찾을 수 없습니다.")
                return
            save_test_cases_to_cache(problem_id, test_cases)
            print("💾 예제를 캐시에 저장했습니다.")
        except Exception as e:
            print(f"❌ 예제 다운로드 실패: {e}")
            return

    print(f"✅ 총 {len(test_cases)}개의 테스트 케이스를 실행합니다.\n")

    # 3. 실행 및 검증
    all_passed = True
    for idx, case in enumerate(test_cases, 1):
        inp = case['input']
        expected = case['output']

        print(f"--- CASE {idx} ---")
        actual, err = run_kotlin(kt_file, inp)

        if err:
            print(f"⚠️ 런타임/컴파일 에러:\n{err}")
            all_passed = False
            continue

        clean_actual = actual.replace("\r", "").rstrip()
        clean_expected = expected.replace("\r", "").rstrip()

        if clean_actual == clean_expected:
            print("✅ 통과!")
        else:
            print("❌ 실패")
            print(f"[Input]\n{inp}")
            print(f"[Expected]\n{clean_expected}")
            print(f"[Actual]\n{clean_actual}")
            all_passed = False
        print()

    if all_passed:
        print("🎉 모든 테스트 케이스 통과! 고생하셨습니다.")
    else:
        print("🔥 일부 케이스 실패. 다시 확인해보세요.")


if __name__ == "__main__":
    main()
