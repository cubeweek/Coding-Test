package problem.leetcode.hard

import java.util.PriorityQueue

class MinimumInitialEnergyToFinishTasks {
    fun minimumEffort(tasks: Array<IntArray>): Int {
        val pq = PriorityQueue<IntArray>(tasks.size) { a, b -> (b[1]-b[0]) - (a[1]-a[0]) }
        for (t in tasks) pq.add(t)

        var answer = 0
        var calc = 0
        while (pq.isNotEmpty()) {
            val now = pq.poll()
            val reqCalc = calc - now[1]
            if (reqCalc < 0) {
                answer -= reqCalc
                calc -= reqCalc
            }
            calc -= now[0]
        }

        return answer
    }
}