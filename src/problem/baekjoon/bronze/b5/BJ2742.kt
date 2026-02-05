package problem.baekjoon.bronze.b5

fun main(args: Array<String>) {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in n downTo 1) {
        sb.appendLine(i)
    }

    print(sb)
}