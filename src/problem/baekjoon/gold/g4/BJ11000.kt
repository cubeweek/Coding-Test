package problem.baekjoon.gold.g4

import java.util.PriorityQueue

private data class Clazz(val st: Int, val ed: Int)

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
    val clazz = ArrayList<Clazz>(n)

    repeat(n) {
        val st = fs.nextInt()
        val ed = fs.nextInt()
        clazz.add(Clazz(st, ed))
    }

    clazz.sortWith(compareBy { it.st })

    val pq = PriorityQueue<Clazz>(compareBy { it.ed })
    pq.add(clazz[0])
    for (i in 1 until n) {
        if (pq.peek().ed <= clazz[i].st) {
            val bef = pq.poll()
            pq.add(Clazz(bef.st, clazz[i].ed))
        } else {
            pq.add(clazz[i])
        }
    }

    println(pq.size)
}