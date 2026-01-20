package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = ArrayList<Int>()
    val haveCnt = br.readLine().toInt()
    var st = StringTokenizer(br.readLine())

    val haveArr = IntArray(20_000_001)
    while(st.hasMoreTokens()) haveArr[st.nextToken().toInt() + 10_000_000]++

    val findCnt = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    while(st.hasMoreTokens()) result.add(haveArr[st.nextToken().toInt() + 10_000_000])

    print(result.joinToString(" "))

    br.close()
}