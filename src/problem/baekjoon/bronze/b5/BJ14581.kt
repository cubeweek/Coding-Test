package problem.baekjoon.bronze.b5

fun main(args: Array<String>) {
    val id = readLine()
    val sb = StringBuilder()
    for (i in 1..3) {
        for (j in 1..3) {
            sb.append(":${if (i==2&&j==2) id else "fan"}:")
        }
        sb.append("\n")
    }
    println(sb)
}