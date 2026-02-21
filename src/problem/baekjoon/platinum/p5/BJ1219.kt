package problem.baekjoon.platinum.p5

import java.util.*

// Bus Metro Walk :)
private data class BMW(val dst: Int, val cost: Int)

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
    val cityCnt = fs.nextInt()
    val srcCity = fs.nextInt()
    val dstCity = fs.nextInt()
    val bmwCnt = fs.nextInt()

    val bmwInfo = Array(cityCnt) { ArrayList<BMW>() }
    repeat (bmwCnt) {
        bmwInfo[fs.nextInt()].add(BMW(fs.nextInt(), fs.nextInt()))
    }

    val gainInfo = IntArray(cityCnt)
    for (i in 0 until cityCnt) { gainInfo[i] = fs.nextInt() }

    val calcResult = LongArray(cityCnt) { Long.MIN_VALUE }
    calcResult[srcCity] = gainInfo[srcCity] + 0L
    repeat (cityCnt - 1) {
        for (s in 0 until cityCnt) {
            for (b in bmwInfo[s]) {
                val dst = b.dst
                if (calcResult[s] != Long.MIN_VALUE
                    && calcResult[dst] < calcResult[s] - b.cost + gainInfo[dst]
                ) {
                    calcResult[dst] = calcResult[s] - b.cost + gainInfo[dst]
                }
            }
        }
    }

    if (calcResult[dstCity] == Long.MIN_VALUE) {
        println("gg")
    } else {
        val finalSave = calcResult.clone()
        for (s in 0 until cityCnt) {
            for (b in bmwInfo[s]) {
                val dst = b.dst
                if (calcResult[s] != Long.MIN_VALUE
                    && calcResult[dst] < calcResult[s] - b.cost + gainInfo[dst]) {
                    calcResult[dst] = calcResult[s] - b.cost + gainInfo[dst]
                }
            }
        }

        val infStack = Stack<Int>()
        val visited = BooleanArray(cityCnt)
        for (i in 0 until cityCnt) {
            if (finalSave[i] != calcResult[i]) infStack.push(i)
        }

        var isInf = false
        while (infStack.isNotEmpty() && !isInf) {
            val now = infStack.pop()
            visited[now] = true
            for (b in bmwInfo[now]) {
                if (b.dst == dstCity) {
                    isInf = true
                    break
                } else if (!visited[b.dst]) {
                    infStack.push(b.dst)
                }
            }
        }

        println(if (isInf) "Gee" else finalSave[dstCity])
    }
}