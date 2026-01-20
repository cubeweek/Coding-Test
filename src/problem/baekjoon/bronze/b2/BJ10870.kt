package problem.baekjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val target = br.readLine().toInt()
    br.close()

    var now = 1
    var bef = 0
    var calc = 1

    if (target <= 1) println(target)
    else {
        for (i in 2 .. target) {
            calc = bef + now
            bef = now
            now = calc
        }
        println(now)
    }
}