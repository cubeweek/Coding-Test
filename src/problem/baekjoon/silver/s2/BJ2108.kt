package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import kotlin.math.round

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val cnt = br.readLine().toInt()
    val numArr = IntArray(cnt)

    for (i in 0 until cnt) numArr[i] = br.readLine().toInt()

    // 산술평균
    sb.appendLine(round(numArr.average()).toInt())

    // 중앙값
    numArr.sort()
    sb.appendLine(numArr[cnt / 2])

    // 최빈값
    val countSort = IntArray(8001)
    for (n in numArr) ++countSort[n + 4000]

    val modeList = ArrayList<Int>()
    val modeCnt = countSort.max()
    for (i in 0..8000) if (modeCnt == countSort[i]) modeList.add(i)
    modeList.sort()
    sb.appendLine((if (modeList.size == 1) modeList[0] else modeList[1]) - 4000)

    // 범위
    sb.appendLine(numArr.max() - numArr.min())

    print(sb.toString())
}