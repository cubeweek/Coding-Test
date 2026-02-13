package problem.baekjoon.bronze.b5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val checker = intArrayOf(1,1,2,2,2,8)
    val st = StringTokenizer(br.readLine())
    for (i in 0 until 6) {
        checker[i] -= st.nextToken().toInt()
    }
    println(checker.joinToString(" "))
}