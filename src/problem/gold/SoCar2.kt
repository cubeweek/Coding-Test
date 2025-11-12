import java.util.*

fun makeBoard(order: Array<IntArray>, n: Int, m: Int): Array<IntArray> {
    val board = Array(n + 1) { IntArray(m + 1) { Int.MAX_VALUE } }
    order.forEachIndexed { idx, xy ->
        val x = xy[0]
        val y = xy[1]
        board[x][y] = idx + 1
    }
    return board
}
fun canReach(disappear: Array<IntArray>, k: Int, n: Int, m: Int): Boolean {
    val visited = Array(n + 1) { BooleanArray(m + 1) }

    if (disappear[1][1] <= k) return false
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(1 to 1)
    visited[1][1] = true

    val dir = arrayOf(1 to 0, -1 to 0, 0 to 1, 0 to -1)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        if (x == n && y == m) return true

        for ((dx, dy) in dir) {
            val nx = x + dx
            val ny = y + dy
            if (nx in 1..n && ny in 1..m && !visited[nx][ny] && disappear[nx][ny] > k) {
                visited[nx][ny] = true
                queue.add(nx to ny)
            }
        }
    }

    return false
}

fun getMinBreakStep(order: Array<IntArray>, n: Int, m: Int): Int {
    val board = makeBoard(order, n, m)
    for (k in 0..order.size) {
        if (!canReach(board, k, n, m)) return k
    }
    return order.size+1
}

fun main() {
    val n = 3
    val m = 4
    val order = arrayOf(
        intArrayOf(3, 2),
        intArrayOf(3, 1),
        intArrayOf(1, 4),
        intArrayOf(1, 2),
        intArrayOf(2, 4),
        intArrayOf(2, 3),
        intArrayOf(2, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 1),
        intArrayOf(3, 3)
    )
    println(getMinBreakStep(order, n, m))
}
