package problem.backjoon.bronze

fun main(args: Array<String>) {
    val x = readln().toInt()

    print(
        when (x % 3) {
            1 -> "U"
            2 -> "O"
            0 -> "S"
            else -> ""
        }
    )
}