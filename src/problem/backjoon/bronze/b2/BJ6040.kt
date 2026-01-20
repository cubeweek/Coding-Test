package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine() ?: return

    println(BigInteger(input, 16).toString(8))
}
