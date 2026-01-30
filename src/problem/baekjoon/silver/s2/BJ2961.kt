package problem.baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val raw = br.readLine().toInt()
    val setList = Array(raw) { 0 to 0 }

    repeat(raw) {
        val st = StringTokenizer(br.readLine())
        setList[it] = st.nextToken().toInt() to st.nextToken().toInt()
    }

    var answer = Int.MAX_VALUE
    var sour: Int
    var bitter: Int

    // 최소 1개는 써야 하므로 1부터 시작
    // 2의 raw승 - 1 = 경우의 수 비트연산을 통한 경우의 수 도출 가능
    for (s in 1 until (1 shl raw)) {
        sour = 1
        bitter = 0
        for (i in 0 until raw) {
            if (s and (1 shl i) != 0) {
                sour *= setList[i].first
                bitter += setList[i].second
            }
        }
        answer = minOf(answer, abs(sour - bitter))
        if (answer == 0) break
    }

    println(answer)
}