package problem.backjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    var answer = IntArray(n)
    val stack = ArrayDeque<Int>()

    numbers.forEachIndexed { i, _ ->
        while (stack.isNotEmpty() && numbers[i] > numbers[stack.peek()]) {
            answer[stack.pop()] = numbers[i]
        }
        stack.push(i)
    }

    while (stack.isNotEmpty()) answer[stack.pop()] = -1
    println(answer.joinToString(" "))

    br.close()
}