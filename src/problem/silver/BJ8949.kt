package problem.silver

import java.lang.StringBuilder

fun main (args: Array<String>) {
    val sb = StringBuilder()
    val (a, b) = readln().split(" ").map { it.toInt() }
    var max = if (a > b) a else b
    var min = if (a < b) a else b

    while (max > 0) {
        sb.insert(0, max%10 + min%10)
        max /= 10
        min /= 10
    }
    print(sb)
}