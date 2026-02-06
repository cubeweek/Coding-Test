package problem.baekjoon.gold.g4

import java.util.*

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cityCnt = br.readLine().toInt()
    val planedCnt = br.readLine().toInt()
    val graph = IntArray(cityCnt + 1) { it }

    fun find(x: Int): Int {
        if (graph[x] != x) graph[x] = find(graph[x])
        return graph[x]
    }

    fun union(a: Int, b: Int) {
        val rep = find(a)
        val chg = find(b)
        if (rep == chg) return
        graph[chg] = rep
    }

    for (i in 1 ..cityCnt) {
        val st = StringTokenizer(br.readLine())
        for (j in 1..cityCnt) {
            if ("0" == st.nextToken()) continue
            union(i, j)
        }
    }

    val st = StringTokenizer(br.readLine())
    val checker = find(st.nextToken().toInt())
    var canTrip = "YES"
    for (i in 1 until planedCnt) {
        if (checker != find(st.nextToken().toInt())) {
            canTrip = "NO"
        }
    }
    print(canTrip)
}