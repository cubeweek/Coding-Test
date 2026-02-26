package problem.baekjoon.silver.s2

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
    val greenOnionCnt = fs.nextInt()
    val chickenCnt = fs.nextInt()
    val goBox = IntArray(greenOnionCnt)
    var goSum = 0L
    for (i in 0 until greenOnionCnt) {
        goBox[i] = fs.nextInt()
        goSum += goBox[i]
    }
    var low = 1L
    var high = 1_000_000_000L
    var bestLen = 0L

    while (low <= high) {
        val mid = (low + high) / 2
        if (mid == 0L) {
            low = 1L
            break
        }

        var count = 0L
        for (onion in goBox) {
            count += (onion / mid)
        }

        if (count >= chickenCnt) {
            bestLen = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    println(goSum - (chickenCnt.toLong() * bestLen))
}