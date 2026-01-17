package problem.backjoon.silver

fun main (args: Array<String>) {
    var target = readln().toInt()
    var title = 665

    while (target > 0) {
        ++title
        if (title.toString().contains("666")) {
            --target
        }
    }
    println(title)
}