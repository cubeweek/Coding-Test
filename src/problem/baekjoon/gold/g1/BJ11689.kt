package problem.baekjoon.gold.g1

import kotlin.math.sqrt

fun main(args: Array<String>) {
    var n = readln().toLong()

    var answer = n
    for (p in 2L..sqrt(n.toDouble()).toLong()) {
        if (n % p == 0L) {
            answer -= answer / p
            while (n % p == 0L) n /= p
        }
    }

    if (n > 1) answer -= answer / n
    println(answer)
}