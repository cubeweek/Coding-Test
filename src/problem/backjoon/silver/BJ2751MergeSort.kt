package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val numArr = IntArray(cnt)
    val answer = IntArray(cnt)

    for (i in 0 until cnt) {
        numArr[i] = br.readLine().toInt()
    }

    val mid = cnt / 2
    var gr1 = 0
    var gr2 = mid




    br.close()
}