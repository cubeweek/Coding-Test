package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val stack = ArrayDeque<Int>()
    var inputCnt = br.readLine().toInt()

    while (inputCnt-- > 0) {
        val now = br.readLine()
        when (now) {
            "pop" -> sb.appendLine( if (stack.isEmpty()) -1 else stack.pop() )
            "size" -> sb.appendLine(stack.size)
            "empty" -> sb.appendLine( if (stack.isEmpty()) 1 else 0)
            "top" -> sb.appendLine( if (stack.isEmpty()) -1 else stack.peek() )
            else ->
                stack.push(now.split(" ")[1].toInt())
        }
    }

    print(sb.toString())

    br.close()
}