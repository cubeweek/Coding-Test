package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = br.readLine().toInt()
    val wordSet = HashSet<String>()

    while (count-- > 0) wordSet.add(br.readLine())

    wordSet.sortedWith(compareBy({ it.length }, { it })).forEach {
        println(it)
    }
}