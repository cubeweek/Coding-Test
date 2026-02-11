package problem.baekjoon.gold.g3

import java.util.StringTokenizer

fun main (args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val diffList = Array(n + 1) { ArrayList<Int>() }
    val tallCnt = IntArray(n + 1)

    repeat(m) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        diffList[a].add(b)
        tallCnt[b]++
    }

    val result = IntArray(n)
    var cnt = 0
    while (cnt < n) {
        for (i in 1..n) {
            if (0 == tallCnt[i]) {
                for (d in diffList[i]) tallCnt[d]--
                tallCnt[i] = -1
                result[cnt++] = i
            }
        }
    }
    println(result.joinToString(" "))
}