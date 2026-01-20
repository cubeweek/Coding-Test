package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val inputCnt = br.readLine().toInt()
    repeat (inputCnt) {
        val stand = ArrayList<Int>()
        var moveCounter = 0

        val now = br.readLine().split(" ").map { it.toInt() }

        for (i in 1..20) {
            var pos = stand.size
            for (p in 0 until stand.size) {
                if (stand[p] > now[i]) {
                    pos = p
                    break
                }
            }
            moveCounter += stand.size - pos
            stand.add(pos, now[i])
        }
        sb.appendLine("${now[0]} $moveCounter")
    }
    println(sb.toString())
}