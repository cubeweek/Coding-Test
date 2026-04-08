package problem.baekjoon.gold.g4

import java.util.PriorityQueue

fun main(args: Array<String>) {
    data class Road(val src: Int, val dst: Int, val cost: Int)
    val fs = object {
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

    while (true) {
        val houseCnt = fs.nextInt()
        val roadCnt = fs.nextInt()

        if (houseCnt == 0 && roadCnt == 0) break

        val pq = PriorityQueue<Road>(roadCnt, compareBy { it.cost })
        repeat(roadCnt) {
            pq.add(Road(fs.nextInt(), fs.nextInt(), fs.nextInt()))
        }

        val parent = IntArray(houseCnt) { it }
        fun find(x: Int): Int {
            if (x != parent[x]) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(new: Int, old: Int) {
            val n = find(new)
            val o = find(old)
            if (n != o) parent[o] = n
        }

        var connCnt = 0
        var minCost = 0
        var totCost = 0

        while (connCnt < houseCnt - 1) {
            val now = pq.poll()
            totCost += now.cost
            if (find(now.src) != find(now.dst)) {
                union(now.src, now.dst)
                connCnt++
                minCost += now.cost
            }
        }

        while (pq.isNotEmpty()) {
            totCost += pq.poll().cost
        }

        println(totCost - minCost)
    }
}