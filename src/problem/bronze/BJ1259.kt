package problem.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    while (true) {
        val input = br.readLine()
        if ("0" == input) break

        sb.appendLine( if (input == input.reversed()) "yes" else "no" )
    }
    print(sb.toString())

    br.close()
}