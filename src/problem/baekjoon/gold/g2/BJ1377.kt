package problem.baekjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val eleCnt = br.readLine().toInt()
    val arr = Array(eleCnt) { br.readLine().toInt() }
    val indexedArr = arr.withIndex().toList().sortedBy { it.value }

    var maxChangeCnt = 0
    for (i in indexedArr.indices) {
        maxChangeCnt = max(indexedArr[i].index - i, maxChangeCnt)
    }
    print(maxChangeCnt + 1)

    br.close()
}