package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val cnt = br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val vote = HashMap<String, Int>()

    while (st.hasMoreTokens()) vote[st.nextToken()] = 0
    repeat (cnt) {
        val stz = StringTokenizer(br.readLine())
        while (stz.hasMoreTokens()) {
            val nt = stz.nextToken()
            vote[nt] = vote[nt]!! + 1
        }
    }
    val sortedVote = vote.entries
            .sortedWith(compareByDescending<Map.Entry<String, Int>> { it.value }
            .thenBy { it.key })

    sortedVote.forEach {
        sb.appendLine("${it.key} ${it.value}")
    }
    println(sb.toString())
}