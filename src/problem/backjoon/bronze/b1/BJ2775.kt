package problem.backjoon.bronze.b1

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val inputCnt = br.readLine().toInt()
    val apt = Array(15) { IntArray(15) { 0 } }

    for (i in 1..14) apt[0][i] = i
    for (i in 1..14) {
        for (j in 1..14) {
            apt[i][j] = apt[i-1][j] + apt[i][j-1]
        }
    }

    val sb = StringBuilder()
    repeat (inputCnt) {
        val floor = br.readLine().toInt()
        val no = br.readLine().toInt()
        sb.appendLine(apt[floor][no])
    }
    println(sb.toString())

    br.close()
}