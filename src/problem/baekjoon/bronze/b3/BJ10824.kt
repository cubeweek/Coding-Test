package problem.baekjoon.bronze.b3

fun main(args: Array<String>) {
    val (a, b, c, d) = readln().split(" ")
    println( (a + b).toLong() + (c + d).toLong())
}