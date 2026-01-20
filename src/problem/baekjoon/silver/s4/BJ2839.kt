package problem.baekjoon.silver

fun main(args: Array<String>) {
    val sugar = readln().toInt()
    var answer = Int.MAX_VALUE

    for (i in 0..sugar / 5 + 1) {
        val calc = sugar - (5 * i)
        if (calc < 0) break
        else if (calc % 3 == 0) answer = minOf(answer, i + ((sugar - (5 * i)) / 3))
    }


    print(if (answer == Int.MAX_VALUE) -1 else answer)
}