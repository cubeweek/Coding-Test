package problem.baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.PriorityQueue

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val q = PriorityQueue<Int> { a, b ->
        val absA = Math.abs(a)
        val absB = Math.abs(b)
        if (absA == absB) if (a > b) 1 else -1
        else absA - absB
    }
    val inputCnt = br.readLine().toInt()

    repeat (inputCnt) {
        val now = br.readLine().toInt()

        when (now) {
            0 -> sb.appendLine(if (q.isNotEmpty()) q.poll() else 0)
            else -> q.add(now)
        }
    }
    print(sb.toString())

    br.close()
}