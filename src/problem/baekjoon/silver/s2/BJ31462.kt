package problem.baekjoon.silver.s2

import java.io.BufferedReader
import java.io.InputStreamReader

fun sigma(num: Int):Long = num * (num + 1) / 2L
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tri = Array(n) { CharArray(n) }
    val checker = Array(n) { BooleanArray(n) }

    var result = if (sigma(n) % 3 != 0L) 0 else 1

    for (i in 0 until n) {
        val choco = br.readLine()
        for (j in 0..i) {
            tri[i][j] = choco[j]
        }
    }

    for (i in 0 until n - 1) {
        if (0 == result) break
        for (j in 0..i) {
            if (checker[i][j]) continue
            val now = tri[i][j]

            val updY = if ('R' == now) i + 1 else i
            val updX = if ('R' == now) j else j + 1

            if (now != tri[updY][updX] || now != tri[i+1][j+1]
                || checker[updY][updX] || checker[i+1][j+1]) {
                result = 0
                break
            } else {
                checker[i][j] = true
                checker[updY][updX] = true
                checker[i+1][j+1] = true
            }
        }
    }

    for (i in 0 until n) {
        if (0 == result) break
        if (!checker[n - 1][i]) {
            result = 0
            break
        }
    }

    print(result)
}