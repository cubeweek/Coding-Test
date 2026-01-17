package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, k) = br.readLine().split(" ").map { it.toInt() }
    var answer = 0
    val coins = IntArray(n)

    for (i in 0 until n) coins[i] = br.readLine().toInt()

    for (i in n-1 downTo  0) {
        if (k / coins[i] > 0) {
            answer += k / coins[i]
            k %= coins[i]
        }
    }

    print(answer)
}