package problem.baekjoon.silver.s2

fun main(args: Array<String>) {
    var (a, b) = readln().split(" ").map { it.toInt() }

    var leftCnt = 0
    var rightCnt = 0
    while (a != b) {
        if (a > b) {
            a -= b
            leftCnt++
        } else {
            b -= a
            rightCnt++
        }
    }
    println("$leftCnt $rightCnt")
}