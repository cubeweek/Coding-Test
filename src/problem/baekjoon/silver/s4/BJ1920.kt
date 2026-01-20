package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val inputCnt = br.readLine().toInt()
    val existArr = HashSet<Int>()
    var st = StringTokenizer(br.readLine())
    while (st.hasMoreTokens()) existArr.add(st.nextToken().toInt())

    val checkCnt = br.readLine().toInt()
    st = StringTokenizer(br.readLine())
    while (st.hasMoreTokens()) sb.appendLine( if (existArr.contains(st.nextToken().toInt())) 1 else 0 )

    print(sb.toString())

    br.close()
}