package problem.baekjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val lesson = IntArray(n)

    val st = StringTokenizer(br.readLine())
    var s = 0
    var e = 0;

    for (i in 0 until n) {
        lesson[i] = st.nextToken().toInt()
        if (s < lesson[i]) s = lesson[i]
        e += lesson[i]
    }

    while (s <= e) {
        val mid = (s + e) / 2
        var sum = 0
        var useCnt = 0
        for (i in 0 until n) {
            if (sum + lesson[i] > mid) {
                useCnt++
                sum = 0
            }
            sum += lesson[i]
        }
        if (sum != 0) useCnt++

        if (useCnt > m) s = mid + 1
        else e = mid - 1
    }

    print(s)
}