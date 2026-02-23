package problem.baekjoon.silver.s5

import kotlin.math.abs

fun main(args: Array<String>) {
    val n = readln().toInt()
    val nPow = n / 2 + n % 2
    var answer = 1

    repeat(nPow) {
        answer = (answer shl 1) % 16769023
    }


    println(answer)
}