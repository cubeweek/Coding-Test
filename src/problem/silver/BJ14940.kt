package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Coord(val y: Int, val x: Int)
data class Path(val c: Coord, val step: Int)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val map = Array(h) { IntArray(w) }
    val checker = Array(h) { BooleanArray(w) }
    val result = Array(h) { IntArray(w) }
    val q = ArrayDeque<Path>()
    val guideX = intArrayOf(0, -1, 0, 1)
    val guideY = intArrayOf(-1, 0, 1, 0)

    fun rangeCheck(y: Int, x: Int) = y in 0 until h && x in 0 until w

    for (i in 0 until h) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until w) {
            val now = st.nextToken().toInt()
            map[i][j] = now
            if (2 == now) {
                q.add(Path(Coord(i, j), 0))
                checker[i][j] = true
            }
        }
    }

    while (q.isNotEmpty()) {
        val now = q.poll()
        checker[now.c.y][now.c.x] = true
        result[now.c.y][now.c.x] = now.step
        for (i in 0..3) {
            val y = now.c.y + guideY[i]
            val x = now.c.x + guideX[i]

            if (rangeCheck(y, x) && 1 == map[y][x] && !checker[y][x]) q.add(Path(Coord(y, x), now.step + 1))
        }
    }

    for (i in 0 until h) {
        for (j in 0 until w) {
            if (1 == map[i][j] && !checker[i][j]) result[i][j] = -1
        }
    }


    val sb = StringBuilder()
    for (i in 0 until h) {
        sb.appendLine(result[i].joinToString(" "))
    }
    println(sb.toString())
}