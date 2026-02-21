package problem.baekjoon.gold.g4

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val alpha = IntArray(26)

    repeat(n) {
        val now = br.readLine()
        var weight = 1
        for (i in now.length-1 downTo 0) {
            alpha[now[i] - 'A'] += weight
            weight *= 10
        }
    }
    alpha.sortDescending()
    var result = 0
    var currNum = 9
    for (a in alpha) {
        if (a != 0) {
            result += a * currNum
            --currNum
        }
    }

    println(result)
}