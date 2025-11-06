package problem.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(arg: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sb = StringBuilder()
    val testCnt = br.readLine().toInt()

    for (i in 1..testCnt) {
       // 공통 알파벳을 제외하고 남는 알파벳의 갯수
        val w1 = br.readLine()
        var w2 = br.readLine().toCharArray().toMutableList()

        var removeCnt = 0

        for (w in w1) if (w2.remove(w)) removeCnt++

        sb.appendLine("Case #$i: ${w1.length - removeCnt + w2.size}")
    }

    print(sb.toString())
    br.close()
}