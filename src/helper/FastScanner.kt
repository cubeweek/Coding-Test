package helper

import java.io.BufferedInputStream

private class FastScanner {
    private val input = BufferedInputStream(System.`in`)
    private val buffer = ByteArray(1 shl 16)
    private var len = 0
    private var cur = 0

    private fun readByte(): Int {
        if (cur >= len) {
            len = input.read(buffer)
            cur = 0
            if (len <= 0) return -1
        }
        return buffer[cur++].toInt()
    }

    fun nextInt(): Int {
        var c: Int
        // skip whitespace
        do {
            c = readByte()
        } while (c in 0..32)

        var n = 0
        while (c > 32) {
            n = n * 10 + (c - '0'.code)
            c = readByte()
        }
        return n
    }
}