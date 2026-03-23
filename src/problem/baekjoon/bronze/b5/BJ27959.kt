package problem.baekjoon.bronze.b5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val st = StringTokenizer(readln())
    println(if (st.nextToken().toInt() * 100 - st.nextToken().toInt() >= 0) "Yes" else "No")
}