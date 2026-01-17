package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val state = IntArray(n)

    var s = 1
    var e = Int.MIN_VALUE

    val st = StringTokenizer(br.readLine())
    for (i in 0 until n) {
        state[i] = st.nextToken().toInt()
        if (e < state[i]) e = state[i]
    }
    val budget = br.readLine().toInt()

    while (s <= e) {
        val mid = (s + e) / 2
        var spend = 0
        for (i in 0 until n) spend += minOf(mid, state[i])

        if (spend <=  budget) s = mid + 1
        else e = mid - 1
    }

    print(e)
}