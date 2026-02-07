package problem.baekjoon.silver.s2

import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val map = Array (r) { CharArray(c) }
    val visited = Array (r) { BooleanArray(c) }
    var start = 0 to 0

    for (y in 0 until r) {
        val now = br.readLine()
        for (x in 0 until c) {
            map[y][x] = now[x]
            if ('I' == map[y][x]) start =  y to x
        }
    }

    fun isNewWay(y: Int, x: Int) = (y in 0 until r && x in 0 until c
            && 'X' != map[y][x]
            && !visited[y][x])

    var answer = 0

    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(start)
    while (q.isNotEmpty()) {
        val now = q.poll()
        if (!visited[now.first][now.second]) {
            if ('P' == map[now.first][now.second]) answer++
            if (isNewWay(now.first - 1, now.second)) q.add(now.first - 1 to now.second)
            if (isNewWay(now.first + 1, now.second)) q.add(now.first + 1 to now.second)
            if (isNewWay(now.first, now.second - 1)) q.add(now.first to now.second - 1)
            if (isNewWay(now.first, now.second + 1)) q.add(now.first to now.second + 1)
        }
        visited[now.first][now.second] = true
    }

    println(if (answer == 0) "TT" else answer)
}