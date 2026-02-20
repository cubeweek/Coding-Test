package problem.baekjoon.gold.g2

import java.util.PriorityQueue

private object FastReader {
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

private data class Gem(val weight: Int, val value: Int)

fun main(args: Array<String>) {
    val fs = FastReader
    val gemCnt = fs.nextInt()
    val bagCnt = fs.nextInt()

    val gems = ArrayList<Gem>(gemCnt)
    val bags = IntArray(bagCnt)

    repeat(gemCnt) {
        gems.add(Gem(fs.nextInt(), fs.nextInt()))
    }
    for (i in 0 until bagCnt) bags[i] = fs.nextInt()

    gems.sortWith(compareBy { it.weight })
    bags.sort()

    var gain = 0L
    val candidates = PriorityQueue<Int>(compareByDescending { it })
    var gemCur = 0
    for (b in bags) {
        for (i in gemCur until gemCnt) {
            if (gems[i].weight <= b) {
                candidates.add(gems[i].value)
                gemCur++
            } else {
                break
            }
        }
        if (candidates.isNotEmpty()) gain += candidates.poll()
    }

    println(gain)
}