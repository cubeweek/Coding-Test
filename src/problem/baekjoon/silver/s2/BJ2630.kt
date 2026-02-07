package problem.baekjoon.silver.s2

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val origami = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val now = br.readLine()
        var cur = 0
        for (j in 0 until n) {
            origami[i][j] = now[cur].digitToInt()
            cur += 2
        }
    }
    br.close()

    fun isSameColor(stRow: Int, stCol: Int, size: Int): Boolean {
        val color = origami[stRow][stCol]
        for (i in stRow until stRow + size) {
            for (j in stCol until stCol + size) {
                if (origami[i][j] != color) return false
            }
        }

        for (i in stRow until stRow + size) {
            for (j in stCol until stCol + size) {
                origami[i][j] = 2
            }
        }
        return true
    }

    val counter = IntArray(2)

    var cut = n
    while (cut >= 1) {
        for (r in 0 until n step cut) {
            for (c in 0 until n step cut) {
                val std = origami[r][c]
                if (2 == std) continue
                if (isSameColor(r, c, cut)) {
                    ++counter[std]
                }
            }
        }
        cut /= 2
    }

    println(counter[0])
    println(counter[1])
}