package problem.baekjoon.platinum.p4

import java.util.PriorityQueue

object FastReader {
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

data class Road(val dst: Int, val dit: Int)

fun main(args: Array<String>) {
    val fr = FastReader
    val cityCnt = fr.nextInt()
    val roadCnt = fr.nextInt()
    val kth = fr.nextInt()
    val kthIdx = kth - 1

    val map = Array(cityCnt + 1) { ArrayList<Road>() }
    repeat(roadCnt) {
        val src = fr.nextInt()
        val dst = fr.nextInt()
        val dit = fr.nextInt()
        map[src].add(Road(dst, dit))
    }

    val kthList = Array(cityCnt + 1) { PriorityQueue<Int>(kth,reverseOrder()) }
    val pq = PriorityQueue<Road>(compareBy { it.dit })
    kthList[1].add(0)
    pq.add(Road(1, 0))

    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (kthList[now.dst].size == kth && kthList[now.dst].peek() < now.dit) continue
        for (m in map[now.dst]) {
            if (kthList[m.dst].size < kth || kthList[m.dst].peek() > m.dit + now.dit) {
                if (kthList[m.dst].size == kth) kthList[m.dst].poll()
                kthList[m.dst].add(m.dit + now.dit)
                pq.add(Road(m.dst, m.dit + now.dit))
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..cityCnt) sb.append(if (kthList[i].size == kth) kthList[i].poll() else -1).append("\n")
    println(sb)
}
