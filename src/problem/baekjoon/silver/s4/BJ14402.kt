package problem.baekjoon.silver.s4

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val logCnt = br.readLine().toInt()
    val log = HashMap<String, Int>()

    var nightShiftCnt = 0
    repeat (logCnt) {
        val st = StringTokenizer(br.readLine())
        val name = st.nextToken()
        val action = st.nextToken()

        val currStat = log[name] ?: 0
        // 야근의 조건
        // 들어간 기록 X & 나온 기록 O
        if (action == "+") {
            log[name] = currStat + 1
        } else if (action == "-") {
            if (currStat == 0) nightShiftCnt++
            else if (currStat > 0) log[name] = currStat - 1
        }
    }

    // 들어가서 안나오면
    for (l in log) nightShiftCnt += l.value
    println(nightShiftCnt)
}