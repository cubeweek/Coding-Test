package problem.backjoon.silver

fun main(args: Array<String>) {
    var target = readln().toInt()
    var result = 0
    var lenCnt = 1
    var calc = 9

    target -= calc
    while (target > 0) {
        result += lenCnt * calc
        lenCnt++
        calc *= 10
        target -= calc
    }
    result += (target + calc) * lenCnt
    println(result)
}