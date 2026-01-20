package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main (args: Array<String>) {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    br.close()

    val q = ArrayDeque<Int>((1..n).toList())
    var cursor = (if (n / k > 0) k else (n % k)) - 1
    sb.append("<${q.removeAt(cursor)}")

    while (q.isNotEmpty()) {
        cursor = (cursor + k - 1) % q.size
        sb.append(", ${q.removeAt(cursor)}")
    }
    sb.append(">")
    print(sb.toString())
}