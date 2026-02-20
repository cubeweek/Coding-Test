package problem.baekjoon.silver.s5

import java.util.*

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val times = intArrayOf(4,6,4,10)
    val map = HashMap<String, Int>()
    repeat(n) {
        for (i in 0..3) {
            val st = StringTokenizer(br.readLine())
            while (st.hasMoreTokens()) {
                val now = st.nextToken()
                if ("-" == now) continue
                map[now] = map.getOrDefault(now, 0) + times[i]
            }
        }
    }

    var min = Integer.MAX_VALUE
    var max = Integer.MIN_VALUE
    for (mv in map.values) {
        if (min > mv) min = mv
        if (max < mv) max = mv
    }

    println(if (max - min <= 12) "Yes" else "No")
}