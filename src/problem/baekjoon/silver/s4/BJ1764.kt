package problem.baekjoon.silver.s4

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (notListenCnt, notSeeCnt) = br.readLine().split(" ").map { it.toInt() }
    val lsList = HashSet<String>(minOf(notListenCnt, notSeeCnt))

    repeat (notListenCnt) {
        lsList.add(br.readLine())
    }

    var cnt = 0
    val notListenNSeeList = ArrayList<String>()
    repeat (notSeeCnt) {
        val now = br.readLine()
        if (lsList.contains(now)) {
            notListenNSeeList.add(now)
            cnt++
        }
    }
    notListenNSeeList.sort()

    println(cnt)
    println(notListenNSeeList.joinToString("\n"))
}