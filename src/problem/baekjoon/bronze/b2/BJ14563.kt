package problem.baekjoon.bronze.b2

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())

    val sb = StringBuilder()
    repeat(n) {
        val now = st.nextToken().toInt()
        var calc = 0
        for (i in 1..now/2) {
            if (now % i == 0) calc += i
        }
        calc -= now
        sb.append(
            if (calc == 0) "Perfect"
            else if (calc > 0) "Abundant"
            else "Deficient"
        ).append("\n")
    }

    println(sb)
}