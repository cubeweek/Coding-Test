package problem.platinum

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    val stz = StringTokenizer(br.readLine())

    val deq = ArrayDeque<Node>()
    val sb = StringBuilder()

    for (i in 0 until n) {
        val now = stz.nextToken().toInt()

        while (deq.isNotEmpty() && deq.last().value > now) deq.removeLast()
        deq.addLast(Node(i, now))
        if (deq.first().index <= i - l) deq.removeFirst()
        sb.append(deq.first().value).append(" ")

    }
    println(sb.toString())
    br.close()
}

class Node(var index: Int, var value: Int)