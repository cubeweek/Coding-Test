package problem.baekjoon.bronze.b2

import java.util.StringTokenizer
import kotlin.math.max

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val checkInCnt = br.readLine().toInt()
    var useFreeze = true
    var buyCountdown = 0

    var answer = 0
    var currCnt = 0
    val st = StringTokenizer(br.readLine())
    for(c in 1..checkInCnt) {
        val now = st.nextToken().toInt()

        if (c == buyCountdown) useFreeze = true

        if (now > 0) currCnt++
        else if (useFreeze) {
            useFreeze = false
            buyCountdown = c + 2
        } else {
            answer = max(answer, currCnt)
            currCnt = 0
        }
    }
    answer = max(answer, currCnt)
    println(answer)
}