package problem.baekjoon.bronze.b3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val inputCnt = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(inputCnt) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        sb.append(
            if (x in 0..23 && y in 0..59)  "Yes" else "No"
        )
        sb.append(" ")
        sb.appendLine(
            if (x in 1..12) {
                when (x) {
                    1,3,5,7,8,10,12 -> if (y in 1..31) "Yes" else "No"
                    4,6,9,11 -> if (y in 1..30) "Yes" else "No"
                    else -> if (y in 1..29) "Yes" else "No"
                }
            } else "No"
        )
    }

    print(sb.toString())

    br.close()
}