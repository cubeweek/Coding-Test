package problem.baekjoon.silver

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val exp = StringTokenizer(readln(), "-")

    var answer = exp.nextToken().split("+").map { it.toInt() }.sum()

    while (exp.hasMoreTokens()) {
        val now = StringTokenizer(exp.nextToken(), "+")
        while(now.hasMoreTokens()) answer -= now.nextToken().toInt()
    }
    println(answer)
}