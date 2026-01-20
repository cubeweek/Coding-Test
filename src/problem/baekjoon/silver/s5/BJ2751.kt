package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var cnt = br.readLine().toInt()
    val numList = ArrayList<Int>()

    while (cnt-- > 0) numList.add(br.readLine().toInt())
    numList.sort()
    numList.forEach { sb.appendLine(it) }
    println(sb.toString())

    br.close()
}