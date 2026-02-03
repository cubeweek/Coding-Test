package problem.baekjoon.gold.g4

import java.util.*
import kotlin.math.min

fun main(args: Array<String>) {
    val st = StringTokenizer(readln())
    val capacity = IntArray(3) { st.nextToken().toInt() }
    val barrel = IntArray(3)
    barrel[2] = capacity[2]

    val graph = arrayOf(
        0 to 1, 0 to 2,
        1 to 0, 1 to 2,
        2 to 0, 2 to 1
    )

    fun key() = (barrel[0] shl 20) or (barrel[1] shl 10) or barrel[2]

    val setOfAnswer = HashSet<Int>()

    val checked = HashSet<Int>()
    checked.add(key())
    setOfAnswer.add(barrel[2])

    fun dfs () {
        for ((from, to) in graph) {
            if (0 == barrel[from]) continue
            if (capacity[to] == barrel[to]) continue

            val move = min(barrel[from],  capacity[to] - barrel[to])
            barrel[from] -= move
            barrel[to] += move
            if (checked.add(key())) {
                if (0 == barrel[0]) setOfAnswer.add(barrel[2])
                dfs()
            }
            barrel[to] -= move
            barrel[from] += move
        }
    }
    dfs()

    println(setOfAnswer.sorted().joinToString(" "))

}