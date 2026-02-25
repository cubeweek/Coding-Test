package problem.baekjoon.silver.s1

import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random.Default.nextInt

fun main(args: Array<String>) {
    class FastReader {
        val buffer = ByteArray(1 shl 16)
        var lim = 0
        var cur = 0

        @Suppress("NOTHING_TO_INLINE")
        private inline fun readByte(): Int {
            if (cur >= lim) {
                lim = System.`in`.read(buffer)
                if (lim <= 0) return -1
                cur = 0
            }
            return buffer[cur++].toInt()
        }

        fun nextInt(): Int {
            var c = readByte()
            while (c in 0..32) c = readByte()
            if (c == -1) return 0

            var isNeg = false
            if (c == 45) {
                isNeg = true
                c = readByte()
            }

            var res = 0
            while (c in 48..57) {
                res = (res shl 3) + (res shl 1) + (c and 15)
                c = readByte()
            }
            return if(isNeg) -res else res
        }
    }

    val fs = FastReader()
    val n = fs.nextInt()
    val graph = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) graph[i][j] = fs.nextInt()
    }

    for (k in 0 until n) {
        for (s in 0 until n) {
            for (d in 0 until n) {
                if (graph[s][k] == 1 && graph[k][d] == 1) {
                    graph[s][d] = 1
                }
            }
        }
    }

    val sb = StringBuilder()
    for (i in 0 until n) sb.append(graph[i].joinToString(" ")).append("\n")
    println(sb.toString())
}