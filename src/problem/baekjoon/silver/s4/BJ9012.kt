package problem.baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val cnt = br.readLine().toInt()
    val stack = ArrayDeque<Char>()

    for (i in 1..cnt) {
        val input = br.readLine()
        stack.clear()

        input.forEach {
            if (stack.isNotEmpty() && '(' == stack.peek() && it == ')') stack.pop()
            else stack.push(it)
        }
        sb.appendLine(if (stack.isEmpty()) "YES" else "NO")
    }
    print(sb.toString())

    br.close()
}