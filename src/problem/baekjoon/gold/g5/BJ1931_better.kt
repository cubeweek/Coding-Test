package problem.baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val meetingCnt = br.readLine().toInt()
    val needs = LongArray(meetingCnt)

    for (i in 0 until meetingCnt) {
        val st = StringTokenizer(br.readLine())
        needs[i] = st.nextToken().toLong() or (st.nextToken().toLong() shl 32 )
    }

    needs.sort()

    var result = 0
    var end = 0L

    for (n in needs) {
        if (n.toInt() >= end) {
            end = n ushr 32
            ++result
        }
    }
    print(result)
}