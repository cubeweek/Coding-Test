package problem.baekjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val word = br.readLine()
    br.close()

    for (w in word) {
        if (w.isUpperCase()) print(w.lowercase())
        else print(w.uppercase())
    }
}