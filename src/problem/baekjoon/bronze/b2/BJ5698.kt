package problem.baekjoon.bronze.b2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main (args: Array<String>) {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val now = br.readLine().split(" ")

        if ("*" == now[0]) break

        var checker = "Y"
        var tauto = now[0][0].lowercase()
        for (i in 1 until now.size) {
            if (tauto != now[i][0].lowercase()) {
                checker = "N"
                break
            }
        }
        sb.appendLine(checker)
    }
    println(sb.toString())
}