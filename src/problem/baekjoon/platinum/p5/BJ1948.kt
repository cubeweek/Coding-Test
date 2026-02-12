package problem.baekjoon.platinum.p5

import java.util.ArrayDeque
import java.util.StringTokenizer

data class Road(val dest: Int, val dist: Int)

fun main (args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cityCnt = br.readLine().toInt()
    val roadCnt = br.readLine().toInt()
    val map = Array(cityCnt + 1) { ArrayList<Road>() }
    val revMap = Array(cityCnt + 1) { ArrayList<Road>() }
    val roadCtr = IntArray(cityCnt + 1)
    val maxScore = LongArray(cityCnt + 1)

    repeat (roadCnt) {
        val st = StringTokenizer(br.readLine())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        map[from].add(Road(to,t))
        revMap[to].add(Road(from,t))
        roadCtr[to]++
    }

    val (oneWay, rome) = br.readLine().split(" ").map { it.toInt() }
    br.close()

    val q = ArrayDeque<Int>()
    q.add(oneWay)
    while (q.isNotEmpty()) {
        val now = q.poll()
        for (n in map[now]) {
            maxScore[n.dest] = maxOf(maxScore[n.dest], maxScore[now] + n.dist)
            if (0 == --roadCtr[n.dest]) q.add(n.dest)
        }
    }

    var goldenRoad = 0
    val visited = BooleanArray(cityCnt + 1)
    q.add(rome)
    visited[rome] = true
    while (q.isNotEmpty()) {
        val now = q.poll()
        for (n in revMap[now]) {
            if (maxScore[now] == maxScore[n.dest] + n.dist) {
                goldenRoad++
                if (!visited[n.dest]) {
                    visited[n.dest] = true
                    q.add(n.dest)
                }
            }
        }
    }
    println("${maxScore[rome]}\n$goldenRoad")
}