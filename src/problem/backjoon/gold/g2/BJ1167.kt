package problem.backjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class TreeInfo(val v: Int, val w: Int)
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val tree = Array (cnt + 1) { ArrayList<TreeInfo>() }
    val calc = IntArray(cnt + 1)
    val visitChecker = BooleanArray(cnt + 1)

    repeat (cnt) {
        val st = StringTokenizer(br.readLine())
        val target = st.nextToken().toInt()
        while (true) {
            val v = st.nextToken().toInt()
            if (-1 == v) break

            tree[target].add(TreeInfo(v, st.nextToken().toInt()))
        }
    }

    val q = ArrayDeque<TreeInfo>()
    fun bfs(v: Int) {
        visitChecker[v] = true
        for (t in tree[v]) {
            q.add(t)
        }
        while (q.isNotEmpty()) {
            val now = q.poll()
            if (!visitChecker[now.v]) {
                visitChecker[now.v] = true
                calc[now.v] = now.w
                for (n in tree[now.v]) {
                    if (!visitChecker[n.v]) {
                        q.add(TreeInfo(n.v, n.w + now.w))
                    }
                }
            }
        }
    }

    bfs(1)
    var maxIdx = -1
    var maxVal = Int.MIN_VALUE
    for (i in 1..cnt) {
        if (calc[i] > maxVal) {
            maxVal = calc[i]
            maxIdx = i
        }
    }
    for (i in 1..cnt) {
        calc[i] = 0
        visitChecker[i] = false
    }
    bfs(maxIdx)
    println(calc.max())
}