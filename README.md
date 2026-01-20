# Coding-Test

이 레포는 [백준](https://www.acmicpc.net/) / [LeetCode](https://leetcode.com/)의 문제 풀이 소스와 관련 유틸 프로그램들의 백업 목적으로 생성되었습니다!

| Baekjoon                                                                                               | LeetCode                                                                                   |
|--------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------|
| [![solved.ac](http://mazassumnida.wtf/api/v2/generate_badge?boj=cubeweek)](https://solved.ac/cubeweek) | ![LeetCode Stats](https://leetcode-badge-sage.vercel.app/badge/cube_week-99?theme=neutral) |
<!--img src="https://leetcode-badge-showcase.vercel.app/api?username=cube_week-99&animated=true" alt="LeetCode Badges" /-->


## 푼 문제 / 소스 Link

---
레포 내에 존재하는 백준 / 리트코드 문제와 소스 링크를 [문제].[소스] 형태로 보실 수 있습니다.

### Baekjoon - Solved Index
<!-- BACKJOON-AUTO-GENERATED:START -->
<sub>[1259](https://www.acmicpc.net/problem/1259).[src](src/problem/backjoon/bronze/b1/BJ1259.kt)</sub>
<!-- BACKJOON-AUTO-GENERATED:END -->

### LeetCode - Solved Index
<!-- LEETCODE-AUTO-GENERATED:START -->
<!-- LEETCODE-AUTO-GENERATED:END -->


## Utilities

---
관련 유틸들은 모두 Python 기반으로 만들어져 사용하시려면 Python 및 추가 라이브러리들의 설치가 필요합니다.

<details>
<summary><strong>Baekjoon 예제 자동 채점(Kotlin ONLY!)</strong></summary>
한땀 한땀 실행-예제를 입력하던 불편함을 딸-깍 한 번으로 해결하기 위해<br>
백준 문제 페이지의 예제 입력/출력을 자동으로 가져와(재시도부터는 캐시 사용) 로컬에서 Kotlin 풀이를 컴파일/실행하고 결과를 비교합니다.

- Script: `autotest_baekjoon.py`
  - What it does:
      - BOJ 문제 페이지에서 sample input/output을 수집합니다. (Selenium 사용)
      - 수집한 예제는 `.boj_cache/{problemId}.json`에 캐시합니다.
      - `src/problem/baekjoon/**/BJ{problemId}.kt` 파일을 찾아 `kotlinc`로 컴파일 후 실행합니다.
      - 각 케이스별로 출력이 일치하는지 확인하고, 불일치 시 Expected/Actual을 출력합니다.

#### Requirements
- Python 3
  - Google Chrome (headless)
  - `selenium`, `BeautifulSoup`등의 라이브러리가 없는 경우 설치 필요

#### Usage
- 인텔리제이 External Tools에 등록하여 사용

  <a href="./resources/setting_auto_test_baekjoon.png">
    <img src="./resources/setting_auto_test_baekjoon.png" width="400" />
  </a>

- 터미널에서 사용할 경우(레포 최상위에서 실행)
  ```bash
  # 사용방법1 : BJ1300.kt를 찾아서 예제 케이스로 테스트
  python3 ./src/util/autotest_baekjoon.py BJ1300
  ```
  ```bash
  # 사용방법2 : 생성된 백준 예시 캐시 파일을 모두 삭제하고 싶은 경우
  python3 ./src/util/autotest_baekjoon.py clear
  ```
</details>