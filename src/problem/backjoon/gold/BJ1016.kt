package problem.backjoon.gold

fun main(args: Array<String>) {
    val (min, max) = readln().split(" ").map { it.toLong() }
    val nums = BooleanArray((max - min).toInt() + 1)

    var i = 2L
    var pow = i * i
    while (pow <= max) {
        val minStart = min / pow + if (0L != min % pow) 1 else 0
        var j = minStart
        while (pow * j <= max) {
            nums[(j * pow - min).toInt()] = true // offset 적용하여 실제 배열 좌표 찾아감
            j++
        }

        i++
        pow = i * i
    }

    var answer = 0
    for (n in nums) if (!n) ++answer

    println(answer)
}