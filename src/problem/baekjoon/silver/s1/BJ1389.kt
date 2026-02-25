package problem.baekjoon.silver.s1

import kotlin.math.min

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
    val m = fs.nextInt()

    val frMtx = Array(n + 1) { IntArray(n + 1) { 101 } }
    for(i in 1..n) frMtx[i][i] = 0

    repeat(m) {
        val src = fs.nextInt()
        val dst = fs.nextInt()
        if (101 == frMtx[src][dst]) frMtx[src][dst] = 1
        if (101 == frMtx[dst][src]) frMtx[dst][src] = 1
    }

    for (k in 1..n) {
        for (s in 1..n) {
            for (d in 1..n) {
                frMtx[s][d] = min(frMtx[s][d], frMtx[s][k] + frMtx[k][d])
            }
        }
    }
    var calc = Int.MAX_VALUE
    var whoIsInssa = -1
    for (i in 1..n) {
        val nowSum = frMtx[i].slice(1..n).sum()
        if (calc > nowSum) {
            calc = nowSum
            whoIsInssa = i
        }
    }
    println(whoIsInssa)
}