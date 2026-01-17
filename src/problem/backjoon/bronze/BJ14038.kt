package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var win = 0
    var answer = -1
    for (game in 1..6) if ("W" == br.readLine()) ++win

    when (win) {
        in 5..6 -> answer = 1
        in 3..4 -> answer = 2
        in 1..2 -> answer = 3
    }
    println(answer)

    br.close()
}