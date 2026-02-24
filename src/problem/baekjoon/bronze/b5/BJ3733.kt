package problem.baekjoon.bronze.b5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()

    val sb = StringBuilder()
    while(true) {
        val st = StringTokenizer(br.readLine() ?: break)
        val n = st.nextToken().toInt() + 1
        val s = st.nextToken().toInt()
        sb.append(s / n).append('\n')
    }
    println(sb)
}