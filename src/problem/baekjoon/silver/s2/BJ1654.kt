package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val lan = LongArray(n)

    var s = 1L
    var e = 0L

    for (i in 0 until n) {
        lan[i] = br.readLine().toLong()
        e = maxOf(e, lan[i])
    }

    while (s <= e) {
        val mid = (s + e) / 2
        var makeCnt = 0L

        for (i in 0 until n) makeCnt += lan[i] / mid

        if (makeCnt >= k) s = mid + 1
        else e = mid - 1
    }

    println(e)
}