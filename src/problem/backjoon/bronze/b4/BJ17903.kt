package problem.backjoon.bronze

fun main (args: Array<String>) {
    val (m, n) = readln().split(" ").map { it.toInt() }
    // repeat(m) { readln() }
    println( if (m >= 8) "satisfactory" else "unsatisfactory")
}