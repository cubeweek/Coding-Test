package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    var inputCnt = br.readLine().toInt()


    val cursorNow = ArrayDeque<Char>()
    val wait = ArrayDeque<Char>()


    str.forEach { cursorNow.push(it) }

    while (inputCnt-- > 0) {
       var now = br.readLine()
       when(now) {
           "L" -> if (cursorNow.isNotEmpty()) wait.push(cursorNow.pop())
           "D" -> if (wait.isNotEmpty()) cursorNow.push(wait.pop())
           "B" -> if (cursorNow.isNotEmpty()) cursorNow.pop()
           else -> cursorNow.push(now.split(" ")[1][0])
       }
    }

    val sb = StringBuilder()
    while (cursorNow.isNotEmpty()) wait.push(cursorNow.pop())
    while (wait.isNotEmpty()) sb.append(wait.pop())

    print(sb.toString())

    br.close()
}