package problem.backjoon.bronze

import java.lang.StringBuilder
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val msg = readln()
    val len = msg.length

    var r = 1
    var c = len
    for (i in 2..sqrt(len.toDouble()).toInt()) {
        if (len % i == 0) {
            r = i
            c = len / i
        }
    }

    var cur = 0
    val procession = Array(r) { CharArray(c) }
    for (i in 0 until c) {
        for (j in 0 until r) {
            procession[j][i] = msg[cur++]
        }
    }

    val sb = StringBuilder()
    for (i in 0 until r) {
        for (j in 0 until c) {
            sb.append(procession[i][j])
        }
    }

    println(sb.toString())
}