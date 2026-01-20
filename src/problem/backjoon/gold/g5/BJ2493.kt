package problem.backjoon.gold.g5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val towerCnt = br.readLine().toInt()
    val tower = br.readLine().split(" ").map { it.toInt() }
    val stack = ArrayDeque<Int>()
    val answer = IntArray(towerCnt)

    tower.forEachIndexed { i, t ->
        while (stack.isNotEmpty() && tower[stack.peek()] < t) stack.pop()
        if (stack.isNotEmpty()) answer[i] = stack.peek() + 1
        stack.push(i)
    }

    print(answer.joinToString(" "))

    br.close()
}