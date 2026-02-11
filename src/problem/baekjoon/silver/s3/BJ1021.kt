package problem.baekjoon.silver.s3

import java.util.StringTokenizer
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val q = ArrayDeque<Int>(n)
    for (i in 1..n) q.add(i)

    val target = IntArray(m)
    val st = StringTokenizer(br.readLine())
    for (i in 0 until m) target[i] = st.nextToken().toInt()


    var cur = 0
    var moveCnt = 0
    while (cur < m) {
        val to = q.indexOf(target[cur])
        val mid = q.size / 2 + q.size % 2

        if (to + 1 <= mid) {
            repeat(to) {
                q.add(q.poll())
            }
            moveCnt += to
        } else if (to + 1 > mid) {
            repeat(q.size - to) {
                q.addFirst(q.pollLast())
            }
            moveCnt += q.size - to
        }
        q.poll()
        cur++
    }
    println(moveCnt)
}