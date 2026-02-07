package problem.baekjoon.silver.s2

import java.util.StringTokenizer
import java.util.Arrays

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = IntArray(n)
    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) arr[i] = st.nextToken().toInt()

    val sorted = arr.clone()
    Arrays.sort(sorted)

    val rank = HashMap<Int, Int>(n)
    var r = 0
    var prev: Int? = null
    for (v in sorted) {
        if (prev == null || v != prev) {
            rank[v] = r++
            prev = v
        }
    }

    val sb = StringBuilder()
    for (i in 0 until n) sb.append(rank[arr[i]]).append(' ')
    print(sb)
}
