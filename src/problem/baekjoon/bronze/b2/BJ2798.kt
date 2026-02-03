package problem.baekjoon.bronze.b2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    var cards = br.readLine().split(" ").map { it.toInt() }
    var isDone = false
    var maxScore = -1

    for (a in 0..n-3) {
        var calc = cards[a]
        for (b in a+1..n-2) {
            calc += cards[b]
            for (c in b+1 until n) {
                calc += cards[c]
                if (calc in (maxScore + 1)..m) maxScore = calc
                calc -= cards[c]
            }
            calc -= cards[b]
        }
    }
    println(maxScore)

    br.close()
}