package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, w) = br.readLine().split(" ").map { it.toInt() }
    val maze = Array(h + 1) { IntArray(w + 1) }
    val stepChecker = Array(h + 1) { BooleanArray(w + 1) }

    // 안쓰는 배열 0 부분 방문처리
    for (i in 0..w) stepChecker[0][i] = true
    for (i in 0..h) stepChecker[i][0] = true

    for (i in 1 ..h) {
        val info = br.readLine()
        for (j in 1..w) {
            maze[i][j] = info[j - 1].digitToInt()
        }
    }

    var answer = Int.MAX_VALUE
    var isFind = false
    fun findExit(nowY: Int, nowX: Int, step: Int) {
        if (maze[nowY][nowX] == 0 || isFind) return
        if (h == nowY && w == nowX) {
            answer = step
            isFind = true
            return
        }

        stepChecker[nowY][nowX] = true
        if (!stepChecker[nowY - 1][nowX]) findExit(nowY - 1, nowX, step + 1)
        if (nowY + 1 <= h && !stepChecker[nowY + 1][nowX]) findExit(nowY + 1, nowX, step + 1)
        if (!stepChecker[nowY][nowX - 1]) findExit(nowY, nowX - 1, step + 1)
        if (nowX + 1 <= w && !stepChecker[nowY][nowX + 1]) findExit(nowY, nowX + 1, step + 1)
        stepChecker[nowY][nowX] = false
    }

    findExit(1, 1, 1)
    println(answer)
}