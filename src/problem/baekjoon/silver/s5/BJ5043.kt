package problem.baekjoon.silver.s5

fun main (args: Array<String>) {
    val (n, b) = readln().split(" ").map { it.toLong() }
    val maxLen = (1L shl (b + 1).toInt()) - 1
    println(if (n <= maxLen) "yes" else "no")
}