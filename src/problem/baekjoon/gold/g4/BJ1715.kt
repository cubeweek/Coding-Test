package problem.baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.PriorityQueue

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()

    repeat(n) {
        pq.add(br.readLine().toInt())
    }

    var accCalc = 0
    while (pq.size > 1) {
        val calc = pq.poll() + pq.poll()
        accCalc += calc
        pq.add(calc)
    }

    print(accCalc)
}