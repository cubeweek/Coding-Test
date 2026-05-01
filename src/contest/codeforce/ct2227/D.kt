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
        val arr = IntArray(n * 2) { fs.nextInt() }
        val startAt = IntArray(n)
        val howFar = IntArray(n) { -1 }
        for (i in 0 until n*2) {
            val now = arr[i]
            if (howFar[now] == -1) {
                howFar[now] = i
                startAt[now] = i
            } else howFar[now] = i - howFar[now]
        }
        var mex = 1

        val list = mutableListOf<Pair<Int, Int>>()
        var stPos = 0
        var farCnt = howFar

        // 다음에 어떻게?
    }
    println(sb.toString())
}