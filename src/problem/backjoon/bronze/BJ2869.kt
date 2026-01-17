package problem.backjoon.bronze

fun main(args: Array<String>) {
    val (a, b, v) = readln().split(" ").map { it.toInt() }
    val calc = v - a
    var answer = 1
    answer += calc / (a - b)
    if (calc % (a - b) > 0) ++answer

    println(answer)
}