package problem.baekjoon.gold.g4

import java.io.BufferedInputStream
import java.util.*

private data class Edge(val dest: Int, val dist: Int)

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

fun main(args: Array<String>) {
    val fs = FastScanner()
    val v = fs.nextInt()
    val e = fs.nextInt()
    val start = fs.nextInt()
    val graph = Array (v + 1) { ArrayList<Edge>() }
    val minDist = IntArray(v + 1) { Int.MAX_VALUE }
    minDist[start] = 0

    repeat(e) {
        val from = fs.nextInt()
        val to = fs.nextInt()
        val dist = fs.nextInt()
        graph[from].add(Edge(to, dist))
    }

    val q = PriorityQueue<Edge>(compareBy { it.dist })
    q.add(Edge(start, 0))
    while (q.isNotEmpty()) {
        val now = q.poll()
        if (now.dist > minDist[now.dest]) continue
        for (f in graph[now.dest]) {
            if (minDist[f.dest] > minDist[now.dest] + f.dist) {
                minDist[f.dest] = minDist[now.dest] + f.dist
                q.add(Edge(f.dest, minDist[f.dest]))
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1..v) {
        sb.append(if (minDist[i] == Int.MAX_VALUE) "INF" else minDist[i]).append("\n")
    }

    println(sb)
}