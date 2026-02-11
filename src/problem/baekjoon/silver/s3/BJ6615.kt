package problem.baekjoon.silver.s3

import java.util.StringTokenizer

fun getCollatz(a0: Long): HashMap<Long, Int> {
    val map = HashMap<Long, Int>(2048)
    var a = a0
    var step = 0
    map[a] = 0
    while (a != 1L) {
        a = if (a % 2L == 0L) a / 2L else a * 3L + 1L
        step++
        map.putIfAbsent(a, step)
    }
    return map
}

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()

    while (true) {
        val line = br.readLine() ?: break
        if (line.isBlank()) continue
        val st = StringTokenizer(line)

        val a0 = st.nextToken().toLong()
        val b0 = st.nextToken().toLong()
        if (a0 == 0L && b0 == 0L) break

        val aMap = getCollatz(a0)

        var curB = b0
        var bStep = 0

        while (true) {
            val aStep = aMap[curB]
            if (aStep != null) {
                sb.append("$a0 needs $aStep steps, $b0 needs $bStep steps, they meet at $curB\n")
                break
            }
            curB = if (curB % 2L == 0L) curB / 2L else curB * 3L + 1L
            bStep++
        }
    }

    print(sb.toString())
}
