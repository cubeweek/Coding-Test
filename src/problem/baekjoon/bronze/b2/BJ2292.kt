package problem.baekjoon.bronze

fun main(args: Array<String>) {
    var target = readln().toInt()
    var calcHexagon = 6
    var answer = 1

    while (target > 1) {
        target -= calcHexagon
        calcHexagon += 6
        answer++
    }
    println(answer)
}