package problem.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val cnt = br.readLine().toInt()

    repeat (cnt) {
        sb.appendLine(br.readLine().split(" ").sorted().joinToString(" "))
    }
    println(sb.toString())

    br.close()
}


//