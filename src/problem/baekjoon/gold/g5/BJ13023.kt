package problem.baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var list: Array<ArrayList<Int>>
lateinit var visited: BooleanArray
var isFive = false
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    list = Array(n) { ArrayList() }
    visited = BooleanArray(n)

    repeat (m) {
        val (from, to) = br.readLine().split(" ").map { it.toInt() }
        list[from].add(to)
        list[to].add(from)
    }

    for (i in 0 until n) {
        findLinkedFive(i , 1)
        if (isFive) break
    }

    print(if (isFive) 1 else 0)
}

fun findLinkedFive(now: Int, depth: Int) {
    if (depth == 5) {
        isFive = true
        return
    }
    visited[now] = true
    for (i in list[now]) {
        if (!visited[i]) findLinkedFive(i, depth + 1)
    }
    visited[now] = false
}