package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    var cnt = br.readLine().toInt()
    val countingSort = BooleanArray(2_000_001)

    while (cnt-- > 0) countingSort[br.readLine().toInt() + 1_000_000] = true
    countingSort.withIndex()
        .filter { it.value }
        .forEach { sb.appendLine(it.index - 1_000_000) }
    println(sb.toString())

    br.close()
}