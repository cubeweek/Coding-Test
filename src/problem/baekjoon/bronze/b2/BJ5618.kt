package problem.baekjoon.bronze.b2

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val n = readln().toInt()
    val nums = IntArray(n)

    var minNum = Integer.MAX_VALUE
    val st = StringTokenizer(readln())
    for (i in 0 until n) {
        nums[i] = st.nextToken().toInt()
        if (minNum > nums[i]) minNum = nums[i]
    }

    val sb = StringBuilder("1\n")
    for (x in 2..minNum) {
        var isComDiv = true
        for (i in 0 until n) {
            if (nums[i] % x != 0) {
                isComDiv = false
                break
            }
        }
        if (isComDiv) sb.append("$x\n")
    }
    println(sb.toString())
}