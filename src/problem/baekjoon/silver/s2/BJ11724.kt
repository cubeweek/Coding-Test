package problem.baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { ArrayList<Int>() }
    val reminder = BooleanArray(n + 1)
    var dfsCounter = 0
    val stack = ArrayDeque<Int>()

    repeat(m) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }

    for (i in 1..n) {
        if (!reminder[i]) {
            dfsCounter++
            reminder[i] = true
            stack.push(i)

            while (stack.isNotEmpty()) {
                graph[stack.pop()].forEach {
                    if (!reminder[it]) {
                        reminder[it] = true
                        stack.push(it)
                    }
                }
            }
        }
    }

    println(dfsCounter)
}