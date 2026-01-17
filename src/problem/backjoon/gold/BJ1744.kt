package problem.backjoon.gold

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    val pqMinus = PriorityQueue<Int>()
    var one = 0
    var zero = 0

    val n = br.readLine().toInt()
    repeat(n) {
        when (val now = br.readLine().toInt()) {
            0 -> zero++
            1 -> one++
            in Int.MIN_VALUE..-1 -> pqMinus.add(now)
            else -> pq.add(now)
        }
    }

    var answer = 0

    while (pq.size > 1) answer += pq.poll() * pq.poll()
    while (pqMinus.size > 1) answer += pqMinus.poll() * pqMinus.poll()

    if (pq.isNotEmpty()) answer += pq.poll()
    if (pqMinus.isNotEmpty() && 0 == zero) answer += pqMinus.poll()
    answer += 1 * one

    println(answer)
}