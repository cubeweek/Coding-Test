package problem.baekjoon.gold.g4

private data class Bus(val st: Int, val ed: Int, val dist: Int)

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
    val busCnt = fs.nextInt()

    val busTable = Array(busCnt) { Bus(0,0,0) }
    for (i in 0 until busCnt) busTable[i] = Bus(fs.nextInt(), fs.nextInt(), fs.nextInt())

    val answer = LongArray (cityCnt + 1) { Long.MAX_VALUE }
    answer[1] = 0
    repeat (cityCnt - 1) {
        for (i in 0 until busCnt) {
            val src = answer[busTable[i].st]
            if (src != Long.MAX_VALUE
                && answer[busTable[i].ed] > src + busTable[i].dist) {
                answer[busTable[i].ed] = src + busTable[i].dist
            }
        }
    }

    var isMinusCycle = false
    for (i in 0 until busCnt) {
        val src = answer[busTable[i].st]
        if (src != Long.MAX_VALUE
            && answer[busTable[i].ed] > src + busTable[i].dist) {
            isMinusCycle = true
            break
        }
    }

    if (isMinusCycle) {
        println(-1)
    } else {
        val sb = StringBuilder()
        for (i in 2..cityCnt) {
            sb.append(if (answer[i] == Long.MAX_VALUE) -1 else answer[i]).append("\n")
        }
        print(sb)
    }
}