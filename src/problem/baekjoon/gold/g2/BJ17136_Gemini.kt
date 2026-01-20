package problem.baekjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val board = Array(10) { IntArray(10) }
    var totalOneCount = 0

    for (i in 0 until 10) {
        val st = StringTokenizer(br.readLine())
        for (j in 0 until 10) {
            board[i][j] = st.nextToken().toInt()
            if (board[i][j] == 1) totalOneCount++
        }
    }

    val stock = intArrayOf(0, 5, 5, 5, 5, 5)
    var answer = Int.MAX_VALUE

    fun canAttach(x: Int, y: Int, size: Int): Boolean {
        if (x + size > 10 || y + size > 10) return false

        for (i in 0 until size) {
            for (j in 0 until size) {
                if (board[x + i][y + j] == 0) return false
            }
        }
        return true
    }

    fun fillBoard(x: Int, y: Int, size: Int, value: Int) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                board[x + i][y + j] = value
            }
        }
    }

    fun dfs(x: Int, y: Int, cnt: Int) {
        if (cnt >= answer) return
        if (x == 10) {
            answer = minOf(answer, cnt)
            return
        }

        val nextX = if (y + 1 == 10) x + 1 else x
        val nextY = if (y + 1 == 10) 0 else y + 1

        if (board[x][y] == 1) {
            for (size in 5 downTo 1) {
                if (stock[size] > 0 && canAttach(x, y, size)) {
                    stock[size]--
                    fillBoard(x, y, size, 0)

                    dfs(nextX, nextY, cnt + 1)

                    fillBoard(x, y, size, 1)
                    stock[size]++
                }
            }
        } else {
            dfs(nextX, nextY, cnt)
        }
    }

    dfs(0, 0, 0)

    println(if (answer == Int.MAX_VALUE) -1 else answer)
}
