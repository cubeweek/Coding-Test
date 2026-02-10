package problem.baekjoon.silver.s4

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val names = Array(n + 1) { "" }
    val nameToIdx = HashMap<String, Int>(n)

    for (i in 1..n) {
        val name = br.readLine()
        names[i] = name
        nameToIdx[name] = i
    }

    val sb = StringBuilder()
    repeat(m) {
        val q = br.readLine()
        if (q[0] in '0'..'9') sb.append(names[q.toInt()]).append('\n')
        else sb.append(nameToIdx[q]).append('\n')
    }
    print(sb.toString())
}