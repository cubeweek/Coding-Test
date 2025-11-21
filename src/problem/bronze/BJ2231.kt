package problem.bronze

import java.io.BufferedReader

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val target = br.readLine().toInt()
    val start = target - 9 * target.toString().length
    var answer = 0
    for (i in start..target) {
        var calc = i
        var loading = i
        while (calc > 0) {
            calc += loading % 10
            loading /= 10
        }
        if (calc == target) {
            answer = calc
            break
        }
    }
    println(answer)

    br.close()
}