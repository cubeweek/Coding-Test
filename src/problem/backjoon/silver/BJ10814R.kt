package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var inputCnt = br.readLine().toInt()
    val ageArr = Array(201) { ArrayList<String>() }

    while (inputCnt-- > 0) {
        val input = br.readLine().split(" ")
        ageArr[input[0].toInt()].add(input[1])
    }

    val sb = StringBuilder()
    ageArr.forEachIndexed { i, v -> if (v.size > 0) v.forEach { sb.appendLine("$i $it") } }

    print(sb.toString())

    br.close()
}