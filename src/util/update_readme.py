import os
import re
from collections import defaultdict
import json
# ===== BOJ config =====
ROOT_BOJ = "src/problem/baekjoon"
BOJ_START = "<!-- BAEKJOON-AUTO-GENERATED:START -->"
BOJ_END = "<!-- BAEKJOON-AUTO-GENERATED:END -->"
TIER_ORDER = {"bronze": 0, "silver": 1, "gold": 2, "platinum": 3, "diamond": 4, "ruby": 5}

# ===== LeetCode config =====
ROOT_LC = "src/problem/leetcode"
LC_START = "<!-- LEETCODE-AUTO-GENERATED:START -->"
LC_END = "<!-- LEETCODE-AUTO-GENERATED:END -->"
LC_ORDER = {"easy": 0, "medium": 1, "hard": 2}
OVERRIDE_LC = "src/settings/leetcode_slug_override.json"

EXTS = (".kt", ".java")


def tier_sort_key(t: str):
    return (TIER_ORDER.get(t.lower(), 999), t.lower())


def lc_sort_key(d: str):
    return (LC_ORDER.get(d.lower(), 999), d.lower())


def pascal_to_kebab(name: str) -> str:
    # TwoSum -> two-sum
    # AddTwoNumbers -> add-two-numbers
    return re.sub(r"([a-z0-9])([A-Z])", r"\1-\2", name).lower()


def replace_block(readme: str, start: str, end: str, block: str):
    if start not in readme or end not in readme:
        raise SystemExit(f"README.md에 블록 마커가 없습니다: {start} ~ {end}")
    pre = readme.split(start)[0] + start + "\n"
    post = "\n" + end + readme.split(end)[1]
    return pre + block + post


# ---------------- BOJ ----------------
def list_boj_files():
    out = []
    for dirpath, _, filenames in os.walk(ROOT_BOJ):
        parts = dirpath.split(os.sep)
        if any(p.startswith(".") for p in parts):
            continue
        for fn in filenames:
            if fn.startswith("BJ") and fn.endswith(EXTS):
                out.append(os.path.join(dirpath, fn).replace("\\", "/"))
    return sorted(out)


def parse_boj_path(path: str):
    # src/problem/backjoon/{tier}/{group}/BJ{num}.{ext}
    m = re.match(rf"^{re.escape(ROOT_BOJ)}/([^/]+)/([^/]+)/BJ(\d+)\.(kt|java)$", path)
    if not m:
        return None
    tier, group, num, ext = m.group(1), m.group(2), int(m.group(3)), m.group(4)
    return tier, group, num, ext


def build_boj_block(paths):
    tiers = defaultdict(lambda: defaultdict(lambda: defaultdict(dict)))  # tier -> group -> num -> {ext:path}

    for p in paths:
        meta = parse_boj_path(p)
        if meta is None:
            continue
        tier, group, num, ext = meta
        tiers[tier][group][num][ext] = p

    lines = []
    for tier in sorted(tiers.keys(), key=tier_sort_key):
        lines.append("<details>")
        lines.append(f"<summary>{tier.upper()}</summary>")
        lines.append("")

        for group in sorted(tiers[tier].keys(), key=lambda g: g.lower()):
            lines.append(f"**{group.upper()}**  ")

            items = []
            for num in sorted(tiers[tier][group].keys()):
                cand = tiers[tier][group][num]
                p = cand.get("kt") or cand.get("java")  # kt 우선
                if not p:
                    continue
                problem = f"https://www.acmicpc.net/problem/{num}"
                items.append(f"<sub>[{num}]({problem}).[src]({p})</sub>")

            lines.append(" ".join(items))
            lines.append("")

        lines.append("</details>")
        lines.append("")

    return "\n".join(lines).rstrip() + "\n"


# ---------------- LeetCode ----------------
def list_lc_files():
    out = []
    for dirpath, _, filenames in os.walk(ROOT_LC):
        parts = dirpath.split(os.sep)
        if any(p.startswith(".") for p in parts):
            continue
        for fn in filenames:
            if fn.endswith(EXTS):
                out.append(os.path.join(dirpath, fn).replace("\\", "/"))
    return sorted(out)


def parse_lc_path(path: str):
    # src/problem/leetcode/{difficulty}/{ProblemName}.{ext}
    m = re.match(rf"^{re.escape(ROOT_LC)}/([^/]+)/([^/]+)\.(kt|java)$", path)
    if not m:
        return None
    diff, name, ext = m.group(1), m.group(2), m.group(3)
    return diff, name, ext

def load_lc_override():
    if not os.path.exists(OVERRIDE_LC):
        return {}
    try:
        with open(OVERRIDE_LC, "r", encoding="utf-8") as f:
            data = json.load(f)
        return data if isinstance(data, dict) else {}
    except Exception:
        return {}

def build_lc_block(paths):
    # diff -> name -> {ext:path}
    diffs = defaultdict(lambda: defaultdict(dict))

    for p in paths:
        meta = parse_lc_path(p)
        if meta is None:
            continue
        diff, name, ext = meta
        diffs[diff][name][ext] = p

    override = load_lc_override()

    lines = []
    # EASY / MEDIUM / HARD를 최상위로
    for diff in ["easy", "medium", "hard"]:
        if diff not in diffs:
            continue

        lines.append("<details>")
        lines.append(f"<summary>{diff.upper()}</summary>")
        lines.append("")

        # HTML 테이블 시작 (헤더 없이 바로 본문 시작)
        lines.append('<table width="100%">')
        lines.append("  <tbody>")

        # 해당 난이도의 모든 문제 링크 생성
        items = []
        for name in sorted(diffs[diff].keys(), key=lambda s: s.lower()):
            cand = diffs[diff][name]
            p = cand.get("kt") or cand.get("java")

            slug = override.get(name) or pascal_to_kebab(name)
            url = f"https://leetcode.com/problems/{slug}/"

            # td 칸 안에 들어갈 링크 포맷
            items.append(f'<a href="{url}">{name}</a> · <a href="{p}">src</a>')

        # 2개씩 쪼개서 <tr> 행 생성
        row_cells = []
        for i, item in enumerate(items):
            row_cells.append(item)

            if len(row_cells) == 2 or i == len(items) - 1:
                # 마지막 행에 빈 칸이 있으면 채워주기
                while len(row_cells) < 2:
                    row_cells.append("")

                # HTML 행 추가 (양쪽 열의 너비를 50%씩 균등 배분)
                lines.append("    <tr>")
                lines.append(f'      <td width="50%">{row_cells[0]}</td>')
                lines.append(f'      <td width="50%">{row_cells[1]}</td>')
                lines.append("    </tr>")
                row_cells = []

        lines.append("  </tbody>")
        lines.append("</table>")
        lines.append("")
        lines.append("</details>")
        lines.append("")

    return "\n".join(lines).rstrip() + "\n"

def main():
    with open("README.md", "r", encoding="utf-8") as f:
        readme = f.read()

    boj_block = build_boj_block(list_boj_files())
    readme2 = replace_block(readme, BOJ_START, BOJ_END, boj_block)

    lc_block = build_lc_block(list_lc_files())
    readme3 = replace_block(readme2, LC_START, LC_END, lc_block)

    if readme3 != readme:
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(readme3)


if __name__ == "__main__":
    main()
