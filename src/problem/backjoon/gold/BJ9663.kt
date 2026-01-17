package problem.backjoon.gold

fun main (args: Array<String>) {
    val nq = readln().toInt()
    var answerCnt = 0

    // 공격 불가 라인(세로, 대각선2) 기록
    val line = BooleanArray(nq) // 세로줄
    val diag1 = BooleanArray(2 * nq) // ↙
    val diag2 = BooleanArray(2 * nq) // ↘

    fun findNoAttack(row: Int) {
        if (row == nq) {
            ++answerCnt
            return
        }

        for (i in 0 until nq) {
            val p1 = i + row
            val p2 = row - i + nq

            if (line[i] || diag1[p1] || diag2[p2]) continue

            line[i] = true
            diag1[p1] = true
            diag2[p2] = true

            findNoAttack(row + 1)

            line[i] = false
            diag1[p1] = false
            diag2[p2] = false
        }
    }

    findNoAttack(0)
    println(answerCnt)
}