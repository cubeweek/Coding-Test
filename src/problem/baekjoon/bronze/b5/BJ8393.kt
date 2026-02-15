package problem.baekjoon.bronze.b5

fun main(args: Array<String>) {
    val num = readln().toInt()
    var answer = 0
    for (i in num downTo 1) answer += i
    println(answer)
}