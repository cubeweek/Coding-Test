package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val input = br.readLine().split(" ")
        val charge = input[0].toInt()
        val job = input[1]
        val amount = input[2].toInt()

        if (0 == charge && 0 == amount && "W" == job ) break;
        when (job) {
            "W" ->
                if (charge - amount < -200) sb.appendLine("Not allowed")
                else sb.appendLine(charge - amount)
            "D" -> sb.appendLine(charge + amount)
        }
    }

    println(sb.toString())

    br.close()
}