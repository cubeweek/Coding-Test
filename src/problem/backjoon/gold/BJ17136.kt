package problem.backjoon.gold

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val stock = intArrayOf(0, 5, 5, 5, 5, 5)
    val board = Array<IntArray>(10) { IntArray(10) }
    val br = BufferedReader(InputStreamReader(System.`in`))
    repeat (10) {
        val st = StringTokenizer(br.readLine())
        for (i in 0..9) {
            board[it][i] = st.nextToken().toInt()
        }
    }

    var answer = Int.MAX_VALUE

    fun checkBoard(x: Int, y: Int, size: Int): Boolean {
        if (x + size > 10 || y + size > 10) return false

        for (i in 0 until size) {
            for (j in 0 until size) {
                if (board[x + i][y + j] == 0) return false
            }
        }
        return true
    }

    fun attach(x: Int, y: Int, size: Int, chg: Int) {
        for (i in 0 until size) {
            for (j in 0 until size) {
                board[x+i][y+j] = chg
            }
        }
    }

    fun attachPaper(xy: Int, cnt: Int) {
        if (xy == 100 || answer <= cnt) {
            answer = minOf(answer, cnt)
            return
        }

        val x = xy / 10
        val y = xy % 10

        if (board[x][y] == 1) {
            for (i in 5 downTo 1) {
                if (stock[i] > 0 && checkBoard(x, y, i)) {
                    --stock[i]
                    attach(x, y, i, 0)
                    attachPaper(xy + 1, cnt + 1)
                    ++stock[i]
                    attach(x, y, i, 1)
                }
            }
        } else {
            attachPaper(xy + 1, cnt)
        }
    }

    attachPaper(0, 0)
    print(if (answer == Int.MAX_VALUE) -1 else answer)
}