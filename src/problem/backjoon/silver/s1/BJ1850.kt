package problem.backjoon.silver.s1

import java.lang.StringBuilder
import java.util.StringTokenizer
private fun euclidean(a: Long, b: Long): Long {
    if (a % b == 0L) return b
    return euclidean(b, a % b)
}
fun main(args: Array<String>) {
    val st = StringTokenizer(readln())
    var a = st.nextToken().toLong()
    var b = st.nextToken().toLong()

    if (a < b) {
        val temp = a
        a = b
        b = temp
    }

    // A와 B의 최대 공약수 = 1의 개수 이므로
    val result = euclidean(a, b)
    val sb = StringBuilder()
    repeat(result.toInt()) {
        sb.append("1")
    }
    println(sb.toString())
}