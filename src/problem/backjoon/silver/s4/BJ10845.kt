package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val queue = ArrayDeque<Int>()
    var inputCnt = br.readLine().toInt()

    while (inputCnt-- > 0) {
        val now = br.readLine()
        when (now) {
            "pop" -> sb.appendLine( if (queue.isEmpty()) -1 else queue.pollFirst() )
            "size" -> sb.appendLine(queue.size)
            "empty" -> sb.appendLine( if (queue.isEmpty()) 1 else 0)
            "front" -> sb.appendLine( if (queue.isEmpty()) -1 else queue.first() )
            "back" -> sb.appendLine( if (queue.isEmpty()) -1 else queue.last() )
            else ->
                queue.add(now.split(" ")[1].toInt())
        }
    }

    print(sb.toString())

    br.close()
}