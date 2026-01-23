package problem.baekjoon.silver.s2

import java.util.*
import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine())

    val city = st.nextToken().toInt()
    val road = st.nextToken().toInt()
    val targetFar = st.nextToken().toInt()
    val start = st.nextToken().toInt()
    val map = Array(city + 1) { ArrayList<Int>() }
    val visited = BooleanArray(city + 1)

    repeat(road) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        map[from].add(to)
    }

    val answer = ArrayList<Int>()
    val q = ArrayDeque<IntArray>()
    q.add(intArrayOf(start, 0))
    while (q.isNotEmpty()) {
        val now = q.poll()
        if (targetFar < now[1]) break
        else if (targetFar == now[1] && !visited[now[0]]) answer.add(now[0])
        visited[now[0]] = true

        for (m in map[now[0]]) {
            if (!visited[m]) q.add(intArrayOf(m, now[1] + 1))
        }
    }

    println(if (answer.isEmpty()) -1 else answer.sorted().joinToString("\n"))

}