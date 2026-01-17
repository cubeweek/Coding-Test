package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val arr = IntArray(10_000_001)
    val nCnt = br.readLine().toInt()

    repeat (nCnt) {
        arr[br.readLine().toInt()]++
    }

    arr.forEachIndexed { i, v ->
        if (v > 0) repeat(v) { bw.write("$i\n") }
    }
    bw.flush()
}