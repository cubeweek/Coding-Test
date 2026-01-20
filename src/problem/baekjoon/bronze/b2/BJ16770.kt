package problem.baekjoon.bronze

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cowCnt = br.readLine().toInt()
    val timeTable = IntArray(1001)

    repeat(cowCnt) {
        val (st, ed, needs) = br.readLine().split(" ").map { it.toInt() }
        for (t in st..ed) {
            timeTable[t] += needs
        }
    }

    var answer = Int.MIN_VALUE
    timeTable.forEach {
        if (answer < it) answer = it
    }
    println(answer)

    br.close()
}