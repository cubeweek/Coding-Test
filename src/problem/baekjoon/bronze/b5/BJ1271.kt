package problem.baekjoon.bronze.b5

import java.math.BigInteger

fun main(args: Array<String>) {
    val (n, m) = readln().split(" ").map { BigInteger(it) }
    println(n.div(m))
    println(n.mod(m))
}