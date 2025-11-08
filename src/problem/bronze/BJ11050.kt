package problem.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    println(factorial(n) / factorial(n-k) / factorial(k))
    br.close()
}

fun factorial(n: Int): Long {
    var result = 1L
    for (i in 2..n) result *= i
    return result
}