package problem.baekjoon.gold.g1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    var answer = 0
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()

    var s = 1
    var e = k

    while (s <= e) {
        val mid = (s + e) / 2
        var minCnt = 0

        for (i in 1..n) {
            minCnt += minOf(mid / i, n)
        }

        if (minCnt < k) s = mid + 1
        else {
            answer = mid
            e = mid - 1
        }
    }

    println(answer)
}