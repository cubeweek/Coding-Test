package problem.backjoon.silver

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

    fun dfs(target: Int) {
        if (reminder[target]) return
        reminder[target] = true
        graph[target].forEach {
            if (!reminder[it]) dfs(it)
        }
    }

    for (i in 1..n) {
        if (!reminder[i]) {
            dfsCounter++
            dfs(i)
        }
    }

    println(dfsCounter)
}