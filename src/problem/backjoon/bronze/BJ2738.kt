package problem.backjoon.bronze;

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val matrixA: Array<IntArray> = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val matrixB: Array<IntArray> = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    br.close();

    for (i in 0 until n) {
        println(IntArray(m) { j -> matrixA[i][j] + matrixB[i][j] }.joinToString(" "))
    }

}