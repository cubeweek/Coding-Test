package problem.baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val st = StringTokenizer(br.readLine())
    val woods = LongArray(n)
    var s = 1L
    var e = 0L
    for (i in 0 until n) {
        woods[i] = st.nextToken().toLong()
        e += woods[i]
    }

    while (s <= e) {
        val mid = (s + e) / 2
        var getWood = 0L

        for (i in 0 until n) getWood += maxOf(woods[i] - mid, 0L)

        if (getWood >= m) s = mid + 1
        else e = mid - 1
    }
    print(e)
}