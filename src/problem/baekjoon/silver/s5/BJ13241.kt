package problem.baekjoon.silver

fun main (args: Array<String>) {
    val (a, b) = readln().split(" ").map { it.toLong() }
    var max = if (a > b) a else b
    var min = if (a > b) b else a
    print( a * b / euclideanCalc(max, min))
}

tailrec fun euclideanCalc(a:Long, b:Long): Long = if (b == 0L) a else euclideanCalc(b, a % b)