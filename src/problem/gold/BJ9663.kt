package problem.gold

import java.lang.Math.abs

fun main (args: Array<String>) {
    val nq = readln().toInt()
    var answerCnt = 0
    val board = IntArray(nq) { -1 }

    fun isChecked(target: Int, pos: Int): Boolean {
        for (i in 0 until pos) {
            // 같은 줄에 있으면 안됨!
            if (board[i] == target) return true

            // 대각에 있어도 안됨!
            if ((abs(board[i]) - abs(target)) == (abs(i) - abs(pos))) return true
        }
        return false
    }

    fun findNoAttack(place: Int) {
        if (place == nq) {
            ++answerCnt
            return
        }

        for (i in 0 until nq) {
            if (!isChecked(i, place)) {
                board[place] = i
                findNoAttack(place + 1)
                board[place] = -1
            }
        }
    }
    findNoAttack(0)


    println(answerCnt)
}