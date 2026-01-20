package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val have = BooleanArray(20_000_001)

    br.readLine()

    val cards = br.readLine().split(" ").map { it.toInt() }
    cards.forEach { v -> have[v + 10_000_000] = true }

    val result = IntArray(br.readLine().toInt())

    val check = br.readLine().split(" ").map { it.toInt() }
    check.forEachIndexed { i, v -> result[i] = if (have[v + 10_000_000]) 1 else 0 }
    println(result.joinToString(" "))
}