package problem.backjoon.silver.s3

fun repaintCount(board: Array<CharArray>, startRow: Int, startCol: Int, startColor: Char): Int {
    var count = 0
    for (i in 0 until 8) {
        for (j in 0 until 8) {
            val expectedColor = if ((i + j) % 2 == 0) startColor else if (startColor == 'W') 'B' else 'W'
            if (board[startRow + i][startCol + j] != expectedColor) count++
        }
    }
    return count
}

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val board = Array(N) { readln().toCharArray() }

    var minCount = Int.MAX_VALUE
    for (i in 0..N - 8) {
        for (j in 0..M - 8) {
            val countW = repaintCount(board, i, j, 'W')
            val countB = repaintCount(board, i, j, 'B')
            minCount = minOf(minCount, countW, countB)
        }
    }
    println(minCount)
}
