package problem.baekjoon.bronze.b1

import java.util.StringTokenizer

fun main(args: Array<String>){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var totalCost = 0

    repeat (n) {
        val info = StringTokenizer(br.readLine())
        val (hour, minute) = info.nextToken().split(":").map { it.toInt() }
        val duration = info.nextToken().toInt()

        if ((hour != 18 && hour != 6)
            || minute + duration < 60) {
            totalCost += duration * if (hour in 7..18) 10 else 5
        } else {
            val currentDue = 60 - minute
            totalCost += currentDue * if (hour in 7..18) 10 else 5
            totalCost += (duration - currentDue) * if ((hour+1)%24 in 7..18) 10 else 5
        }
    }
    println(totalCost)
}