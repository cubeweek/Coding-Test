package problem.baekjoon.bronze

fun main(args: Array<String>) {
    val MODULAR = 1_234_567_891L
    var power = 1L
    var answer = 0L

    val inputLength = readln().toInt()
    val str = readln()

    str.forEachIndexed() { i, v ->
        answer = (answer + (v - 'a' + 1) * power) % MODULAR
        power = power * 31 % MODULAR
    }

    println(answer.toString())
}
