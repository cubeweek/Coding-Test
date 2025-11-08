package problem.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val totCnt = br.readLine().toInt()
    val sizeArr = br.readLine().split(" ").map { it.toInt() }
    val (bundleT, bundleP) = br.readLine().split(" ").map { it.toInt() }
    var tCnt = 0

    sizeArr.forEach {
        tCnt += it / bundleT + if (it % bundleT != 0) 1 else 0
    }

    println(tCnt)
    println("${totCnt / bundleP} ${totCnt % bundleP}")

    br.close()
}