package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val call = br.readLine().toInt()
    val stack = ArrayDeque<Int>()

    repeat(call) {
        val c = br.readLine().toInt()
        if (c == 0) {
            if (stack.isNotEmpty()) stack.pop()
        } else {
            stack.push(c)
        }
    }

    var answer = 0
    while (stack.isNotEmpty()) {
        answer += stack.pop()
    }
    println(answer)
}