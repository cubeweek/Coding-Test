package problem.backjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private data class Node(val v: Int, val r1: Int, val r2: Int)

fun euclidean(a: Long, b: Long): Long {
    if (a % b == 0L) return b
    return euclidean(b, a % b)
}

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tree = ArrayList<ArrayList<Node>>(n)
    var lcm = 1L

    repeat(n) {
        tree.add(ArrayList())
    }

    repeat (n - 1) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val p = st.nextToken().toInt()
        val q = st.nextToken().toInt()
        tree[a].add(Node(b, p, q))
        tree[b].add(Node(a, q, p))

        lcm *= p * q / euclidean(p.toLong(), q.toLong())
    }

    val ratios = LongArray (n)
    val visited = BooleanArray (n)

    fun dfs(node: Int) {
        visited[node] = true
        for (t in tree[node]) {
            val next = t.v
            if (!visited[next]) {
                ratios[next] = ratios[node] * t.r2 / t.r1
                dfs(next)
            }
        }
    }
    ratios[0] = lcm
    dfs(0)

    var mgcd = lcm
    for (i in 1 until n) mgcd = euclidean(mgcd, ratios[i])
    for (i in 0 until n) ratios[i] /= mgcd

    println(ratios.joinToString(" "))
}