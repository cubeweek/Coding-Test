package problem.bronze

fun main (args: Array<String>) {
    val (n, m) = readln().split(" ").map { it.toInt() }
    print(n * m - 1)
}