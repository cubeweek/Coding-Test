package problem.leetcode.medium

import java.util.ArrayDeque

class JumpGameIii {
    fun canReach(arr: IntArray, start: Int): Boolean {
        val len = arr.size
        val visited = BooleanArray(len)

        var cur = start
        val q = ArrayDeque<Int>()
        q.add(start)
        while (q.isNotEmpty() && arr[cur] != 0) {
            cur = q.poll()
            if (!visited[cur]) {
                val forward = cur + arr[cur]
                val backward = cur - arr[cur]
                if (forward in 0 until len) q.add(forward)
                if (backward in 0 until len) q.add(backward)
                visited[cur] = true
            }
        }
        return arr[cur] == 0
    }
}