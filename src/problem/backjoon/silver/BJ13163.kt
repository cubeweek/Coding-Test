package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val inputCnt = br.readLine().toInt()

    repeat (inputCnt) {
        val input = br.readLine().split(" ")
        sb.append("god")
        for (i in 1 until input.size) {
            sb.append(input[i])
        }
        sb.appendLine()
    }

    println(sb.toString())
    br.close()
}