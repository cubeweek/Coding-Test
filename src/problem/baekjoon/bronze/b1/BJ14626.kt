package problem.baekjoon.bronze.b1

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val isbn = br.readLine()
    var calc = 0
    var targetIdx = 0
    isbn.forEachIndexed { idx, c ->
        if (c != '*') {
            calc += c.digitToInt() * if (idx % 2 == 0) 1 else 3
        } else {
            targetIdx = idx
        }
    }

    for (i in 0..9) {
        if ((calc + (i * if (targetIdx % 2 == 0) 1 else 3)) % 10 == 0) {
            println(i)
            break
        }
    }

    br.close()
}