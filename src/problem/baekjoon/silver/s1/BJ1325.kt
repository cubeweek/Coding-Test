package problem.baekjoon.silver.s1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.ArrayDeque

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val (node, edge) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(node + 1) { ArrayList<Int>() }
    repeat (edge) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        graph[b].add(a)
    }

    val result = IntArray(node + 1)
    var maxCount = 0

    for (i in 1..node) {
        val visited = BooleanArray(node + 1)
        val q = ArrayDeque<Int>()
        q.add(i)
        visited[i] = true
        var count = 0

        while (q.isNotEmpty()) {
            val now = q.poll()
            count++
            for (next in graph[now]) {
                if (!visited[next]) {
                    visited[next] = true
                    q.add(next)
                }
            }
        }
        result[i] = count
        if (count > maxCount) maxCount = count
    }

    for (i in 1..node) {
        if (result[i] == maxCount) sb.append(i).append(" ")
    }
    print(sb)
}