package problem.baekjoon.bronze

import java.lang.Integer.min
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val (apple, banana) = readln().split(" ").map { it.toInt() }
    val minCnt = min(banana, apple)
    val sb = StringBuilder()

    for ( i in 1..minCnt) {
        if (apple % i == 0 && banana % i == 0) {
            sb.appendLine("$i ${apple/i} ${banana/i}")
        }
    }

    print(sb.toString())
}