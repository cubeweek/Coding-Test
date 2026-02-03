package problem.baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val tot = br.readLine().toInt()
    val weight = IntArray(tot)
    val height = IntArray(tot)
    val rank = IntArray(tot) { 1 }

    for (i in 0 until tot) {
        val st = StringTokenizer(br.readLine())
        weight[i] = st.nextToken().toInt()
        height[i] = st.nextToken().toInt()
    }

    for (i in 0 until tot) {
        for (j in 0 until tot) {
            if (i == j) continue
            if (height[i] < height[j] && weight[i] < weight[j]) ++rank[i]
        }
    }

    print(rank.joinToString(" "))
}