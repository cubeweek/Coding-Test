package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

fun main (args: Array<String>) {
    val guideX = intArrayOf(0, -1, 0, 1)
    val guideY = intArrayOf(-1, 0, 1, 0)

    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val maze = Array(h) { IntArray(w) }
    val stepChecker = Array(h) { IntArray(w) }
    for (i in 0 until h) {
        val info = br.readLine()
        for (j in 0 until w) {
            maze[i][j] = info[j] - '0'
        }
    }

    fun checkRange(y: Int, x: Int): Boolean = y in 0 until h && x in 0 until w

    val q = ArrayDeque<IntArray>().apply { add(intArrayOf(0,0)) }
    stepChecker[0][0] = 1

    while (q.isNotEmpty()) {
        val now = q.poll()
        if (checkRange(now[0], now[1])) {
            for (c in 0..3) {
                val y = now[0] + guideY[c]
                val x = now[1] + guideX[c]

                if (checkRange(y, x) && 1 == maze[y][x] && 0 == stepChecker[y][x]) {
                    stepChecker[y][x] = stepChecker[now[0]][now[1]] + 1
                    q.add(intArrayOf(y,x))
                }
            }
        }
    }
    print(stepChecker[h-1][w-1])
}