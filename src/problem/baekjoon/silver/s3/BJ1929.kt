package problem.baekjoon.silver

import java.lang.StringBuilder
import kotlin.math.sqrt

fun isPrime(x: Int):Boolean {
    for(i in 2..sqrt(x.toDouble()).toInt()) {
        if (x % i == 0) return false
    }
    return true
}
fun main(args: Array<String>) {
    val sb = StringBuilder()
    var (from, to) = readln().split(" ").map { it.toInt() }

    if (from == 1) from++
    for (i in from..to) {
        if (isPrime(i)) sb.appendLine(i)
    }

    print(sb.toString())
}