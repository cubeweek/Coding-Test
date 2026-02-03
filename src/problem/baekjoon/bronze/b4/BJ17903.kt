package problem.baekjoon.bronze.b4

fun main (args: Array<String>) {
    val (m, n) = readln().split(" ").map { it.toInt() }
    // repeat(m) { readln() }
    println( if (m >= 8) "satisfactory" else "unsatisfactory")
}