package problem.backjoon.bronze.b1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strLen = br.readLine().toInt()
    val str = br.readLine()
    val sb = StringBuilder(6)
    var answer = 0L

    str.forEach {
        if (it in '0'..'9') sb.append(it)
        else if (sb.isNotEmpty()) {
            answer += sb.toString().toInt()
            sb.clear()
        }
    }
    if (sb.isNotEmpty()) {
        answer += sb.toString().toInt()
    }

    println(answer)
    br.close()
}