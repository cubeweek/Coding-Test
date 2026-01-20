package problem.backjoon.silver.s3

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val sb = StringBuilder()
    val (from, to) = readln().split(" ").map { it.toInt() }
    val sieve = BooleanArray(to + 1)
    sieve[1] = true

    for (i in 2..sqrt(to.toDouble()).toInt()) {
        if (sieve[i]) continue
        for (j in i*i..to step i) {
            sieve[j] = true
        }
    }

    for (i in from..to) if (!sieve[i]) sb.appendLine(i)

    print(sb.toString())
}