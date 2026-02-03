package problem.baekjoon.gold.g4

import java.util.*
import kotlin.math.min

const val MASK = (1 shl 10) - 1

fun main(args: Array<String>) {
    val st = StringTokenizer(readln())
    val capacity = IntArray(3) { st.nextToken().toInt() }

    val graph = arrayOf(
        0 to 1, 0 to 2,
        1 to 0, 1 to 2,
        2 to 0, 2 to 1
    )

    fun key(now: IntArray) = (now[0] shl 20) or (now[1] shl 10) or now[2]

    fun getNow(key: Int): IntArray {
        val a = key ushr 20
        val b = (key ushr 10) and MASK
        val c = key and MASK
        return intArrayOf(a, b, c)
    }

    val setOfAnswer = HashSet<Int>()

    val startKey = key(intArrayOf(0, 0, capacity[2]))
    val checked = HashSet<Int>()
    checked.add(startKey)
    setOfAnswer.add(capacity[2])

    val q = ArrayDeque<Int>()
    q.add(startKey)

    while (q.isNotEmpty()) {
        val now = getNow(q.poll())
        for ((from, to) in graph) {
            if (0 == now[from]) continue
            if (capacity[to] == now[to]) continue

            val move = min(now[from],  capacity[to] - now[to])
            now[from] -= move
            now[to] += move

            val keyNow = key(now)
            if (checked.add(keyNow)) {
                if (0 == now[0]) setOfAnswer.add(now[2])
                q.add(keyNow)
            }
            now[to] -= move
            now[from] += move
        }
    }

    println(setOfAnswer.sorted().joinToString(" "))

}