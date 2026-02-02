package problem.baekjoon.silver.s3

import kotlin.math.abs

fun main(args: Array<String>) {
    var target = readln()
    var cursor = 0
    var minusCnt = 0
    while ("0" != target) {
        // 1 지우기
        val count = target.count { it == '1' }
        if (count > 0) {
            minusCnt += count
            target = target.replace("1", "")
        }

        if (target.replace("0", "").isEmpty()) break

        // 1 빼기
        val now = target.toInt()
        val minus = abs(now % 10 - 1)
        minusCnt += minus
        target = (now - minus).toString()
    }

    println(minusCnt)
}
/*
fun main() {
    val N = readln().toInt()
    var num = N
    var cnt = 0

    while (num > 0) {
        if (num.toString().contains("1")) {
            val newNum = num.toString().replaceFirst("1", "").trimStart { it == '0' }
            num = if (newNum.isEmpty()) 0 else newNum.toInt()
        } else {
            num--
        }

        cnt++
    }

    println(cnt)
}*/