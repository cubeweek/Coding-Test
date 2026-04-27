package contest.codeforce.ct2222

import java.util.*

fun main(args: Array<String>) {
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
            return if (isNeg) -res else res
        }
    }
    
    val t = fs.nextInt()

    repeat(t) {
        val n = fs.nextInt()
        val m = fs.nextInt()

        val oddGrp = PriorityQueue<Int>(compareByDescending { it })
        val evenGrp = PriorityQueue<Int>(compareByDescending { it })

        var totalSum = 0
        for (i in 1..n) {
            val value = fs.nextInt()
            totalSum += value
            if (i % 2 != 0) oddGrp.add(value) else evenGrp.add(value)
        }

        val xIndices = IntArray(m) { fs.nextInt() }

        var markedSum = 0
        for (x in xIndices) {
            if (x % 2 != 0) {
                if (oddGrp.isNotEmpty()) {
                    markedSum += oddGrp.poll()
                }
            } else {
                if (evenGrp.isNotEmpty()) {
                    markedSum += evenGrp.poll()
                }
            }
        }

        println(totalSum - markedSum)
    }
}