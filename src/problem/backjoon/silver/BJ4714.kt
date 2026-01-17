package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args :Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val earthWeight = br.readLine().toDouble()
        if (earthWeight < 0) break
        sb.appendLine("Objects weighing " + String.format("%.2f", earthWeight) + " on Earth will weigh " + String.format("%.2f", earthWeight * 0.167) + " on the moon.")

    }
    println(sb.toString())

    br.close()
}