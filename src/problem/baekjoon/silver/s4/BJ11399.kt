package problem.baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    var line = br.readLine().split(" ").map { it.toInt() }
    line = line.sorted()
    var answer = 0
    var sum = 0
    line.forEach {
        answer += sum + it
        sum += it
    }
    print(answer)

    br.close()
}