package problem.baekjoon.silver.s5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val set = IntArray(21)
    val cmdCnt = br.readLine().toInt()

    val sb = StringBuilder()
    repeat(cmdCnt) {
        val st = StringTokenizer(br.readLine())
        val cmd = st.nextToken()
        val x = if (st.hasMoreTokens()) st.nextToken().toInt() else 0

        when (cmd) {
            "add" -> set[x] = 1
            "remove" -> set[x] = 0
            "check" -> sb.appendLine(set[x])
            "toggle" -> set[x] = 1 - set[x]
            "all" -> for (i in 1..20) set[i] = 1
            "empty" -> for (i in 1..20) set[i] = 0
        }
    }

    println(sb)
}