package problem.baekjoon.silver.s2

import java.util.PriorityQueue

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val pq = PriorityQueue<Int>()

    val sb = StringBuilder()
    repeat (cnt) {
        val now = br.readLine().toInt()
        if (0 == now) {
            if (pq.isEmpty()) sb.append("0\n")
            else sb.append("${pq.poll()}\n")
        } else {
            pq.add(now)
        }
    }
    println(sb)
}