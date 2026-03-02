package problem.baekjoon.bronze.b5

fun main(args: Array<String>) {
    val n = readln().toInt()
    val sb = StringBuilder()

    for (i in 1..n) {
        sb.append("Hello World, Judge $i!").append("\n")
    }
    println(sb)
}