package problem.baekjoon.silver

import java.lang.StringBuilder

fun main (args: Array<String>) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    val answer = IntArray(m)
    val checkedArr = BooleanArray(n + 1)

    fun findSeq(len: Int) {
        if (len == m) {
            sb.appendLine(answer.joinToString(" "))
            return
        }

        for (i in 1..n) {
            if (!checkedArr[i]) {
                checkedArr[i] = true
                answer[len] = i
                findSeq(len + 1)
                checkedArr[i] = false
            }
        }
    }

    findSeq(0)

    print(sb.toString())
}
