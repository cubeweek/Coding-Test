package problem.baekjoon.platinum.p5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.ArrayDeque

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val stack = ArrayDeque<Long>()

    while (true) {
        val histogram = br.readLine().split(" ").map { it.toLong() }
        if (0L == histogram[0]) break
        stack.clear()
        var accCnt = 0
        var maxSize = 0L

        for (i in 1 .. histogram[0].toInt()) {
            if (stack.isNotEmpty()) {
                if (histogram[i] >= stack.peek()) accCnt++
                else maxSize = (stack.pop() * accCnt).coerceAtLeast(maxSize)
            } else {
                stack.push(histogram[i])
                accCnt = 1
            }
        }
        if (stack.isNotEmpty()) maxSize = (stack.pop() * accCnt).coerceAtLeast(maxSize)

        sb.appendLine(maxSize)
    }

    print(sb.toString())

    br.close()
}