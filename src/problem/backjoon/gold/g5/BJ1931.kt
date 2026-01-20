package problem.backjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val meetingCnt = br.readLine().toInt()
    val needs = Array(meetingCnt) { IntArray(2) }

    for (i in 0 until meetingCnt) {
        val st = StringTokenizer(br.readLine())
        needs[i][0] = st.nextToken().toInt()
        needs[i][1] = st.nextToken().toInt()
    }

     needs.sortWith(compareBy({it[1]}, {it[0]}))

    var result = 0
    var end = 0

    for (i in 0 until meetingCnt) {
        if (needs[i][0] >= end) {
            end = needs[i][1]
            ++result
        }
    }
    print(result)
}