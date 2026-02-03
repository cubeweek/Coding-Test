package problem.baekjoon.bronze.b3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val abc = IntArray(3)
    val days = br.readLine().toInt()

    repeat (days) {
        br.readLine().split(" ").mapIndexed { i, v -> abc[i] += v.toInt() }
        val min = abc.min()
        if (min < 30) {
            sb.appendLine("NO")
        } else {
            sb.appendLine(min)
            for (i in abc.indices) {
                abc[i] -= min
            }
        }
    }
    println(sb)
}