package problem.backjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.HashMap

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()

    // 1. 첫 번째 줄(원래 등수) 입력 - 맵에 기록 (이름 -> 원래 등수)
    // HashMap이 LinkedHashMap보다 미세하게 더 빠름 (순서 필요 없으면 HashMap ㄱㄱ)
    val st1 = StringTokenizer(readLine())
    val beforeRank = HashMap<String, Int>(n)
    for (i in 1..n) {
        beforeRank[st1.nextToken()] = i
    }

    // 2. 두 번째 줄(나중 등수) 입력 받으면서 바로 계산
    // 메모리 아끼려고 별도 리스트 안 만들고 토크나이저로 바로 처리함
    val st2 = StringTokenizer(readLine())
    val sb = StringBuilder()

    var maxUp = Int.MIN_VALUE // 최대 상승폭
    val candidates = ArrayList<String>() // 정답 후보들

    for (currentRank in 1..n) {
        val name = st2.nextToken()
        val oldRank = beforeRank[name]!!

        val diff = oldRank - currentRank // (원래 등수 - 현재 등수) = 상승폭

        if (diff > maxUp) {
            // 더 큰 상승폭 발견하면 리스트 싹 비우고 새로 시작
            maxUp = diff
            candidates.clear()
            candidates.add(name)
        } else if (diff == maxUp) {
            // 동점자면 추가
            candidates.add(name)
        }
    }

    // 3. 출력 (문제 조건에 따라 정렬이 필요하면 여기서 sort 해야 함)
    // 지금 로직은 '두 번째 줄에 등장한 순서(현재 등수 순)'대로 candidates에 들어감
    // 문제에서 오름차순 정렬 조건 있으면 candidates.sort() 추가해야 혀.

    for (name in candidates) {
        sb.append(name).append(" ")
    }
    println(sb)
}