package contest.codeforce.ct2226

import kotlin.math.min

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

    fun sum(a: Int, b: Int) = (a + b) % 676_767_677
    fun mul(a: Int, b: Int) = (a * b) % 676_767_677

    val testCnt = fs.nextInt()
    val sb = StringBuilder()

    repeat(testCnt) {
        val n = fs.nextInt()
        var cost = 0
        var befNum = fs.nextInt()
        var accSum = befNum
        var accMul = befNum
        repeat(n) {
            val now = fs.nextInt()
            if (befNum > now || sum(accSum,now) < mul(accMul,now)) {
                cost = min(accSum, accMul) % 676_767_677
                accSum = now
                accMul = now
            }
            befNum = now
        }
        sb.append("$cost\n")
    }
    println(sb)
}