package problem.baekjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.pow

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val reward2017 = intArrayOf(0, 5_000_000, 3_000_000, 2_000_000, 500_000, 300_000, 100_000)
    val reward2018 = intArrayOf(0, 5_120_000, 2_560_000, 1_280_000, 640_000, 320_000)
    val rank2017Arr = IntArray(101)
    val rank2018Arr = IntArray(65)

    var cur = 1
    for (i in 1..6) {
        repeat (i) {
            rank2017Arr[cur++] = reward2017[i]
        }
    }

    cur = 1
    var loof = 1
    var rank = 1
    while (rank <= 5) {
        repeat(2.toDouble().pow(rank-1).toInt()) {
            rank2018Arr[cur++] = reward2018[rank]
        }
        rank++
    }

    val sb = StringBuilder()
    val t = br.readLine().toInt()
    repeat (t) {
        val (seven, eight) = br.readLine().split(" ").map { it.toInt() }
        sb.appendLine(rank2017Arr[seven] + rank2018Arr[eight])
    }

    print(sb.toString())

    br.close()
}