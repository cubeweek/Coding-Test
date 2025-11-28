package problem.silver

fun main(args: Array<String>) {
    val (a, b, c, d) = readln().split(" ")
    println( (a + b).toLong() + (c + d).toLong())
}