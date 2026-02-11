package problem.baekjoon.gold.g3

import java.util.StringTokenizer
import java.util.LinkedList
import kotlin.math.max

fun main (args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val bdCnt = br.readLine().toInt()
    val bdTimes = IntArray(bdCnt + 1)
    val bdPreCnt = IntArray(bdCnt + 1)
    val precede = Array (bdCnt + 1) { ArrayList<Int>() }

    for (i in 1..bdCnt) {
        val st = StringTokenizer(br.readLine())
        bdTimes[i] = st.nextToken().toInt()
        while (true) {
            val pre = st.nextToken().toInt()
            if (-1 == pre) break
            precede[pre].add(i)
            bdPreCnt[i]++
        }
    }
    val result = IntArray(bdCnt + 1)
    val q = LinkedList<Int>()
    for (i in 1..bdCnt) if (0 == bdPreCnt[i]) q.add(i)

    while (q.isNotEmpty()) {
        val now = q.poll()
        for (p in precede[now]) {
            result[p] = max(result[now] + bdTimes[now], result[p])
            if (--bdPreCnt[p] == 0) q.add(p)
        }
    }

    for (i in 1..bdCnt) result[i] += bdTimes[i]
    print(result.slice(1..bdCnt).joinToString("\n"))
}