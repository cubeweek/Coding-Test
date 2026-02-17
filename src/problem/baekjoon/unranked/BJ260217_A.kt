package problem.baekjoon.unranked

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val TO = IntArray(m + 1)
    val result = IntArray(n + 1) { -1 }

    val stz = StringTokenizer(br.readLine())
    for (i in 1..m) TO[i] = stz.nextToken().toInt()

    for (p in 1..n) {
        val st = StringTokenizer(br.readLine())
        while (st.hasMoreTokens()) {
            val now = st.nextToken().toInt()
            if (TO[now] > 0) {
                TO[now]--
                result[p] = now
                break
            }
        }
    }
    print(result.slice(1..n).joinToString(" "))
}