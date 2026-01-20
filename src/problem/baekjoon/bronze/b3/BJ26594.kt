package problem.baekjoon.bronze.b3

fun main(args: Array<String>) {
    val brokenKeyboard = readln()
    var befChar = '*'
    var cnt = 0
    var minCnt = Int.MAX_VALUE

    brokenKeyboard.forEach {
        if (befChar == it) cnt++
        else {
            if (minCnt > cnt) minCnt = cnt
            befChar = it
            cnt = 1
        }
    }

    println(cnt)
}