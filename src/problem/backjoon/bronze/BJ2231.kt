package problem.backjoon.bronze

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val target = br.readLine().toInt()
    val start = target - 9 * target.toString().length
    var answer = 0
    for (i in start until target) {
        var calc = i
        var temp = i
        while (temp > 0) {
            calc += temp % 10
            temp /= 10
        }

        if (calc == target) {
            answer = i
            break
        }
    }
    println(answer)

    br.close()
}