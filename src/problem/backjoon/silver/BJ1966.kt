package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val q = ArrayDeque<Int>()

    val testCnt = br.readLine().toInt()

    repeat(testCnt) {
        q.clear()
        val (tot, target) = br.readLine().split(" ").map { it.toInt() }
        val priArr = IntArray(tot)
        val rankArr = IntArray(tot)
        val st = StringTokenizer(br.readLine())
        for (i in 0 until tot) priArr[i] = st.nextToken().toInt()
        val max = priArr.sortedArrayDescending()
        var maxCur = 0

        for (i in 0 until tot) {
            if (priArr[i] == max[maxCur]) {
                rankArr[i] = ++maxCur
            } else {
                q.add(i)
            }
        }
        while (0 == rankArr[target]) {
            val now = q.removeFirst()
            if (priArr[now] == max[maxCur]) {
                rankArr[now] = ++maxCur
            } else {
                q.add(now)
            }
        }
        sb.appendLine(rankArr[target])
    }
    print(sb.toString())
}