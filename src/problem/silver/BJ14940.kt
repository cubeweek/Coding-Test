package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*


fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(h) { IntArray(w) }
    val result = Array(h) { IntArray(w) }
    val q = ArrayDeque<Int>()
    val guideX = intArrayOf(0, -1, 0, 1)
    val guideY = intArrayOf(-1, 0, 1, 0)

    fun rangeCheck(y: Int, x: Int) = y in 0 until h && x in 0 until w

    for (i in 0 until h) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until w) {
            val now = st.nextToken().toInt()
            map[i][j] = now
            if (2 == now) q.add((i shl 16) or j)
        }
    }

    while (q.isNotEmpty()) {
        val now = q.poll()
        val ny = now shr 16
        val nx = now and 0xFFFF
        for (i in 0..3) {
            val y = ny + guideY[i]
            val x = nx + guideX[i]

            if (rangeCheck(y, x) && 1 == map[y][x] && 0 == result[y][x]) {
                result[y][x] = result[ny][nx] + 1
                q.add((y shl 16) or x)
            }
        }
    }

    for (i in 0 until h) {
        for (j in 0 until w) {
            if (1 == map[i][j] && 0 == result[i][j]) result[i][j] = -1
        }
    }

    val sb = StringBuilder()
    for (i in 0 until h) {
        sb.appendLine(result[i].joinToString(" "))
    }
    println(sb.toString())
}