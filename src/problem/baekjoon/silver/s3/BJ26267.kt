package problem.baekjoon.silver.s3

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bankCnt = br.readLine().toInt()
    val sumList = HashMap<Int, Long>()

    repeat(bankCnt) {
        val st = StringTokenizer(br.readLine())
        val key = st.nextToken().toInt() - st.nextToken().toInt()
        val coin = st.nextToken().toLong()
        sumList[key] = (sumList[key] ?: 0L) + coin
    }

    print(sumList.values.max())
}