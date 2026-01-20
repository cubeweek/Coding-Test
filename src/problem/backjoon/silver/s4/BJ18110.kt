package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.roundToInt

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val scoreList = ArrayList<Int>(n)

    repeat (n) {
        scoreList.add(br.readLine().toInt())
    }
    scoreList.sort()

    val correctCut = (n * 0.15).roundToInt()
    if (n > correctCut*2) print(scoreList.subList(correctCut, n - correctCut).average().roundToInt())
    else print(0)
    br.close()
}