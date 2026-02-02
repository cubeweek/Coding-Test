package problem.baekjoon.gold.g4

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val case = br.readLine().toInt()

    repeat (case) {
        val stn = StringTokenizer(br.readLine())
        val v = stn.nextToken().toInt()
        val e = stn.nextToken().toInt()

        val graph = Array(v + 1) { ArrayList<Int>() }
        repeat (e) {
            val stz = StringTokenizer(br.readLine())
            val e1 = stz.nextToken().toInt()
            val e2 = stz.nextToken().toInt()
            graph[e1].add(e2)
            graph[e2].add(e1)
        }

        var isBip = true
        val color = IntArray(v + 1)
        val dq = ArrayDeque<Int>()
        for (i in 1..v) {
            if (color[i] != 0) continue
            color[i] = 1
            dq.add(i)

            while (dq.isNotEmpty() && isBip) {
                val now = dq.pop()
                for (next in graph[now]) {
                    if (color[next] == 0) {
                        color[next] -= color[now]
                        dq.add(next)
                    } else if (color[next] == color[now]) {
                        isBip = false
                        break
                    }
                }
            }
            if (!isBip) break
        }
        sb.appendLine(if (isBip) "YES" else "NO")
    }
    br.close()

    println(sb)
}