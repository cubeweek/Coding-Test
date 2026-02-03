package problem.baekjoon.bronze.b5

fun main(args: Array<String>) {
    val (a,b,c) = readln().split(" ").map { it.toInt() }
    val sb = StringBuilder()
    sb.appendLine((a + b) % c)
    sb.appendLine(((a % c) + (b%c))%c)
    sb.appendLine((a * b)%c)
    sb.appendLine(((a%c) * (b%c))%c)
    print(sb.toString())
}