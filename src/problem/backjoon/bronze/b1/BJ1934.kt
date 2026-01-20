package problem.backjoon.bronze.b1

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


private fun euclidean(a: Int, b: Int): Int {
    if (a % b == 0) return b
    return euclidean(b, a % b)
}
fun main (args: Array<String>) {
    val sb = StringBuilder()
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()

    repeat (cnt) {
        val st = StringTokenizer(br.readLine())
        var a = st.nextToken().toInt()
        var b = st.nextToken().toInt()
        var temp = 0

        if (a < b) {
            temp = a
            a = b
            b = temp
        }
        sb.appendLine(a * b / euclidean(a, b))
    }

    println(sb.toString())
}