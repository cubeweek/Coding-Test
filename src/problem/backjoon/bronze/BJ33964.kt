package problem.backjoon.bronze

import java.lang.StringBuilder

fun main (args: Array<String>) {
    val (x, y) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    repeat(x) { sb.append("1") }
    var answer = sb.toString().toInt()
    sb.clear()

    repeat(y) { sb.append("1") }
    answer += sb.toString().toInt()

    println(answer)
}