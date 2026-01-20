package problem.baekjoon.gold.g5

import kotlin.math.sqrt

fun main(args: Array<String>) {
    val (from, to) = readln().split(" ").map { it.toLong() }
    val sqt = sqrt(to.toDouble()).toInt()
    val nums = BooleanArray(sqt + 1)
    nums[0] = true
    nums[1] = true

    for (i in 2..sqrt(sqt.toDouble()).toInt()) {
        if (nums[i]) continue
        for (j in i*i..sqt step i) nums[j] = true
    }

    var answer = 0
    for (i in 2..sqt) {
        if (!nums[i]) {
            var now = i * i.toLong()
            while (from > now) now *= i

            while (now <= to) {
                ++answer

                if (now > to / i) break
                now *= i
            }
        }
    }

    print(answer)
}