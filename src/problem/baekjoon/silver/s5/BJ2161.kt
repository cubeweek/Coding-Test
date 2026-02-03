package problem.baekjoon.silver.s5

fun main(args: Array<String>) {
    val sb = StringBuilder()
    val n = readln().toInt()
    val q = ArrayDeque<Int>()

    for (i in 1..n) q.add(i)
    while (q.isNotEmpty()) {
        sb.append("${q.removeFirst()} ")
        if(q.isNotEmpty()) q.add(q.removeFirst())
    }
    println(sb.toString().trim())
}