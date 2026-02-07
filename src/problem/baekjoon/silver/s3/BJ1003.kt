package problem.baekjoon.silver.s3

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val fibonacci = Array(41) { IntArray(2) }
    fibonacci[0][0] = 1
    fibonacci[1][1] = 1

    for (i in 2..40) {
        fibonacci[i][0] = fibonacci[i - 1][0] + fibonacci[i - 2][0]
        fibonacci[i][1] = fibonacci[i - 1][1] + fibonacci[i - 2][1]
    }

    val sb = StringBuilder()
    repeat(cnt) {
        val n = br.readLine().toInt()
        sb.append("${fibonacci[n][0]} ${fibonacci[n][1]}\n")
    }

    println(sb)
}