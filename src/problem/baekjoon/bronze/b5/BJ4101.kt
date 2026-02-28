package problem.baekjoon.bronze.b5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()

    val sb = StringBuilder()
    while (true) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        if (a == 0 && b == 0) break

        sb.append(if (a > b) "Yes" else "No").append("\n")
    }
    println(sb)
}