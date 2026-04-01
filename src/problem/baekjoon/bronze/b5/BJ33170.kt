package problem.baekjoon.bronze.b5

fun main(args: Array<String>) {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    println( if (a+b+c <= 21) 1 else 0 )
}