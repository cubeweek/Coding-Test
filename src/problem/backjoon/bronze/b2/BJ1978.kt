package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numCnt = br.readLine().toInt()
    val nums = br.readLine().split(" ").map { it.toInt() }
    var primeCnt = 0

    nums.forEach {
        var isPrime = true
        for (i in 2 until it) {
            if (it % i == 0) {
                isPrime = false
                break;
            }
        }
        if (isPrime) primeCnt++
    }

    if (nums.contains(1)) primeCnt--

    println(primeCnt)

    br.close()
}