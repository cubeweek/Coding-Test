package problem.baekjoon.silver.s4

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (passCnt, quiz) = br.readLine().split(" ").map { it.toInt() }

    val passList = HashMap<String, String>(passCnt)
    repeat (passCnt) {
        val st = StringTokenizer(br.readLine())
        passList[st.nextToken()] = st.nextToken()
    }
    val answer = StringBuilder()
    repeat (quiz) {
        answer.append(passList[br.readLine()]).append("\n")
    }
    print(answer)
}