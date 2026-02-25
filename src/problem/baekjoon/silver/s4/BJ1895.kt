package problem.baekjoon.silver.s4

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
    val r = fs.nextInt()
    val c = fs.nextInt()
    val img = Array(r) { IntArray(c) }

    for (i in 0 until r) {
        for (j in 0 until c) img[i][j] = fs.nextInt()
    }
    val T = fs.nextInt()

    var curY = 2
    var curX = 2
    val arr = IntArray(9)
    val result = IntArray((r-2) * (c-2))
    var curR = 0
    while (true) {
        var now = 0
        for (y in curY-2 ..curY) {
            for (x in curX-2 ..curX) {
                arr[now++] = img[y][x]
            }
        }
        arr.sort()
        result[curR++] = arr[4]
        if (++curX == c) {
            curX = 2
            if (++curY == r) break
        }
    }

    var answer = 0
    for (r in result) if (T <= r) answer++
    println(answer)
}