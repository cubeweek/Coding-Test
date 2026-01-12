package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (vCnt, eCnt, start) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(vCnt + 1) { ArrayList<Int>() }

    repeat (eCnt) {
        val st = StringTokenizer(br.readLine())
        val v1 = st.nextToken().toInt()
        val v2 = st.nextToken().toInt()
        graph[v1].add(v2)
        graph[v2].add(v1)
    }
    for (g in graph) g.sort()

    val checked = BooleanArray(vCnt + 1)

    val dq = ArrayDeque<Int>()

    // DFS 계산
    val dfsResult = ArrayList<Int>()
    dq.push(start)
    while (dq.isNotEmpty()) {
        val pop = dq.pop()
        if (!checked[pop]) {
            dfsResult.add(pop)
            checked[pop] = true
            graph[pop].reversed().forEach { p ->
                if (!checked[p]) dq.push(p)
            }
        }

    }

    for (i in 1..vCnt) checked[i] = false

    // BFS 계산
    val bfsResult = ArrayList<Int>()
    dq.add(start)
    while (dq.isNotEmpty()) {
        val poll = dq.poll()
        if (!checked[poll]) {
            bfsResult.add(poll)
            checked[poll] = true
            graph[poll].forEach { p ->
                if (!checked[p]) dq.add(p)
            }
        }
    }

    println(dfsResult.joinToString(" "))
    println(bfsResult.joinToString(" "))
}