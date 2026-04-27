package contest.codeforce.ct2222

import kotlin.math.max

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

    val testCnt = fs.nextInt()
    val sb = StringBuilder(128)
    repeat(testCnt) {
        val n = fs.nextInt()
        val arr = IntArray(n) { fs.nextInt() }
        val m = arr.sorted()[n / 2]

        val dp = IntArray(n + 1) { (-1e9).toInt() }
        dp[0] = 0

        for (i in 1.. n) {
            var high = 0
            var low = 0
            var mCnt = 0

            for (j in i downTo 1) {
                if (arr[j-1] > m) high++
                else if (arr[j-1] < m) low++
                else mCnt++

                if ((i - j + 1) % 2 != 0) {
                    val half = (i - j + 1) /2
                    if (mCnt > 0 && high <= half && low <= half
                        && dp[j-1] != (-1e9).toInt()) {
                        dp[i] = max(dp[i], dp[j - 1] + 1)
                    }
                }
            }
        }
        sb.append(dp[n]).append("\n")
    }
    println(sb)
}