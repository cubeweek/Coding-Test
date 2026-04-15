package problem.baekjoon.bronze.b1

import kotlin.math.abs

fun main(args: Array<String>) {
    val answer = mapOf(
        'A' to arrayOf(0,0), 'B' to arrayOf(0,1), 'C' to arrayOf(0,2), 'D' to arrayOf(0,3),
        'E' to arrayOf(1,0), 'F' to arrayOf(1,1), 'G' to arrayOf(1,2), 'H' to arrayOf(1,3),
        'I' to arrayOf(2,0), 'J' to arrayOf(2,1), 'K' to arrayOf(2,2), 'L' to arrayOf(2,3),
        'M' to arrayOf(3,0), 'N' to arrayOf(3,1), 'O' to arrayOf(3,2), '.' to arrayOf(3,3)
    )

    var spreadDegree = 0
    for (y in 0..3) {
        val line = readln()
        for (x in 0..3) {
            if (line[x] == '.') continue
            answer[line[x]]?.let {
                spreadDegree += abs(it[0] - y)
                spreadDegree += abs(it[1] - x)
            }
        }
    }

    println(spreadDegree)
}