package problem.baekjoon.bronze.b4

fun main(args: Array<String>) {
    val num = readln().toInt()

    print(
        when (num % 4) {
            3 -> 3
            1 -> if (num / 4 % 2 == 0) 1 else 5
            else -> if (num / 4 % 2 == 0) 2 else 4
        }
    )
}