package problem.baekjoon.bronze.b5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val caseCnt = br.readLine().toInt()

    val sb = StringBuilder()
    for (i in 1..caseCnt) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        sb.append("Case #$i: ${a+b}").append("\n")
    }
    println(sb)
}