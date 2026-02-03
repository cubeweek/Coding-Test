package problem.baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val yArr = Array(200_001) { ArrayList<Int>() }
    var inputCnt = br.readLine().toInt()

    while (inputCnt-- > 0) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        yArr[x + 100_000].add(y)
    }
    yArr.forEachIndexed() { i, v ->
        v.sort()
        v.forEach {
            sb.appendLine("${i-100_000} $it")
        }
    }
    print(sb.toString())

    br.close()
}