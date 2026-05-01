package contest.codeforce.ct2227

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
    val sb = StringBuilder()

    repeat(testCnt) {
        val n = fs.nextInt()
        val bef = IntArray (n) { fs.nextInt() }
        val chk = IntArray(n)
        val aft = IntArray(n)
        var cnt6 = 0
        var cnt2 = 0
        var cnt3 = 0

        for (i in 0 until n) {
            if (bef[i] % 6 == 0) {
                cnt6++
                chk[i] = 6
            } else if (bef[i] % 2 == 0) {
                cnt2++
                chk[i] = 2
            } else if (bef[i] % 3 == 0) {
                cnt3++
                chk[i] = 3
            }
        }

        if (cnt6 == n) sb.append("${bef.joinToString(" ")}\n")
        else {
            val cursor = intArrayOf(0, cnt6, cnt6 + cnt2, n - cnt3)
            for (i in 0 until n) {
                when (chk[i]) {
                    6 -> aft[cursor[0]++] = bef[i]
                    2 -> aft[cursor[1]++] = bef[i]
                    0 -> aft[cursor[2]++] = bef[i]
                    3 -> aft[cursor[3]++] = bef[i]
                }
            }
            sb.append(aft.joinToString(" ")).append("\n")
        }
    }
    println(sb)
}