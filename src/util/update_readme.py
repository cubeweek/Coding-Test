import os
import re
from collections import defaultdict

ROOT = "src/problem/backjoon"
START = "<!-- BACKJOON-AUTO-GENERATED:START -->"
END = "<!-- BACKJOON-AUTO-GENERATED:END -->"

# 정렬 우선순위(여기에 없는 tier도 출력은 됨)
TIER_ORDER = {"bronze": 0, "silver": 1, "gold": 2, "platinum": 3, "diamond": 4, "ruby": 5}
EXTS = (".kt", ".java")

def tier_sort_key(t: str):
    return (TIER_ORDER.get(t.lower(), 999), t.lower())

def list_files(root: str):
    out = []
    for dirpath, _, filenames in os.walk(root):
        parts = dirpath.split(os.sep)
        if any(p.startswith(".") for p in parts):
            continue
        for fn in filenames:
            if fn.startswith("BJ") and fn.endswith(EXTS):
                out.append(os.path.join(dirpath, fn).replace("\\", "/"))
    return sorted(out)

def parse_path(path: str):
    # src/problem/backjoon/{tier}/{group}/BJ{num}.{ext}
    m = re.match(rf"^{re.escape(ROOT)}/([^/]+)/([^/]+)/BJ(\d+)\.(kt|java)$", path)
    if not m:
        return None
    tier, group, num, ext = m.group(1), m.group(2), int(m.group(3)), m.group(4)
    return tier, group, num, ext

def replace_block(readme: str, block: str):
    if START not in readme or END not in readme:
        raise SystemExit("README.md에 AUTO-GENERATED 블록이 없습니다.")
    pre = readme.split(START)[0] + START + "\n"
    post = "\n" + END + readme.split(END)[1]
    return pre + block + post

def build_block(paths):
    # tier -> group -> num -> {"kt": path, "java": path}
    tiers = defaultdict(lambda: defaultdict(lambda: defaultdict(dict)))

    for p in paths:
        meta = parse_path(p)
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
                items.append(f"<sub>[{num}]({problem}.<small>[src]({p})</small>)</sub>")

            lines.append(" ".join(items))
            lines.append("")

        lines.append("</details>")
        lines.append("")

    return "\n".join(lines).rstrip() + "\n"

def main():
    paths = list_files(ROOT)
    block = build_block(paths)

    with open("README.md", "r", encoding="utf-8") as f:
        readme = f.read()

    updated = replace_block(readme, block)
    if updated != readme:
        with open("README.md", "w", encoding="utf-8") as f:
            f.write(updated)

if __name__ == "__main__":
    main()
