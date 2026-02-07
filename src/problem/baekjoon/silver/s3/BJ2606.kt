package problem.baekjoon.silver.s3

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val comCnt = br.readLine().toInt()
    val edgeCnt = br.readLine().toInt()

    val network = IntArray(comCnt + 1) { it }

    fun find(x: Int): Int {
        if (network[x] != x) network[x] = find(network[x])
        return network[x]
    }

    fun union(a: Int, b: Int) {
        val rep = find(a)
        val chg = find(b)
        if (rep != chg) network[chg] = rep
    }

    repeat (edgeCnt) {
        val st = StringTokenizer(br.readLine())
        union(st.nextToken().toInt(), st.nextToken().toInt())
    }

    var answer = 0
    val standard = find(1)
    for (i in 2..comCnt) if (standard == find(i)) answer++
    println(answer)
}