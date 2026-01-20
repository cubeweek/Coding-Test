package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val stack = ArrayDeque<Char>(100)

    val reg = Regex("[^\\(\\)\\[\\]]")
    while (true) {
        var input = br.readLine()
        if ("." == input) break

        stack.clear()
        input = input.replace(reg, "")
        var result = "yes"

        for (c in input) {
            when (c) {
                '[', '(' -> stack.push(c)
                ']', ')' -> if (stack.isEmpty()
                    || (c - if (']' == c) 2 else 1) != stack.pop()) {
                    result = "no"
                    break
                }
            }
        }
        if (stack.isNotEmpty()) result = "no"
        sb.appendLine(result)
    }

    print(sb.toString())
}