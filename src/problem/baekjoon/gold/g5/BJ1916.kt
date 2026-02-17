package problem.baekjoon.gold.g5

import java.io.BufferedInputStream
import java.util.PriorityQueue
import java.util.StringTokenizer

private class FastScanner {
    private val input = BufferedInputStream(System.`in`)
    private val buffer = ByteArray(1 shl 16)
    private var len = 0
    private var cur = 0

    private fun readByte(): Int {
        if (cur >= len) {
            len = input.read(buffer)
            cur = 0
            if (len <= 0) return -1
        }
        return buffer[cur++].toInt()
    }

    fun nextInt(): Int {
        var c: Int
        // skip whitespace
        do {
            c = readByte()
        } while (c in 0..32)

        var n = 0
        while (c > 32) {
            n = n * 10 + (c - '0'.code)
            c = readByte()
        }
        return n
    }
}

private data class BusFee(val dst: Int, val fee: Int)

fun main(args: Array<String>) {
    val fs = FastScanner()
    val city = fs.nextInt()
    val bus = fs.nextInt()

    val map = Array(city + 1) { ArrayList<BusFee>() }

    for (i in 1..bus) {
        val src = fs.nextInt()
        val dst = fs.nextInt()
        val from = fs.nextInt()
        map[src].add(BusFee(dst, from))
    }

    val start = fs.nextInt()
    val end = fs.nextInt()
    val minFee = IntArray (city + 1) { 100_000_001 }
    val pq = PriorityQueue<BusFee>(compareBy { it.fee })

    minFee[start] = 0
    pq.add(BusFee(start, 0))
    while (pq.isNotEmpty()) {
        val now = pq.poll()
        if (minFee[now.dst] < now.fee) continue
        for (bf in map[now.dst]) {
            if (minFee[bf.dst] > minFee[now.dst] + bf.fee) {
                minFee[bf.dst] = minFee[now.dst] + bf.fee
                pq.add(BusFee(bf.dst, minFee[bf.dst]))
            }
        }
    }
    println(minFee[end])
}