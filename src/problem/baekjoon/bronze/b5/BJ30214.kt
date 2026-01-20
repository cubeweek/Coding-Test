package problem.baekjoon.bronze

fun main(args: Array<String>) {
    val (s1, s2) = readln().split(" ").map { it.toDouble() }
    println( if (s1 >= s2 / 2) "E" else "H")
}