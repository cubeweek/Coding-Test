package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    br.close()

    val queue = ArrayDeque<Int>((1..n).toList())

    while (queue.size > 1) {
        queue.removeFirst()
        queue.addLast(queue.removeFirst())
    }

    println(queue.first())
}