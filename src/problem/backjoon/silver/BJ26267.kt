package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bankCnt = br.readLine().toInt()
    val idxInfo = IntArray(bankCnt)
    val openTimes = IntArray(bankCnt)
    val coins = IntArray(bankCnt)

    var bIdx=0
    repeat(bankCnt) {
        val st = StringTokenizer(br.readLine())
        idxInfo[bIdx] = st.nextToken().toInt()
        openTimes[bIdx] = st.nextToken().toInt()
        coins[bIdx] = st.nextToken().toInt()
        ++bIdx
    }

    var maxEarn = Long.MIN_VALUE
    for (i in 0 until bankCnt) {
        var time = openTimes[i]
        var nowEarn = coins[i].toLong()
        for (j in i + 1 until bankCnt) {
            time += idxInfo[j] - idxInfo[j-1]
            if (openTimes[j] == time) nowEarn += coins[j]
        }
        maxEarn = maxOf(maxEarn, nowEarn)
    }

    print(maxEarn)
}