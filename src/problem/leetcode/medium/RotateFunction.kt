package problem.leetcode.medium

import kotlin.math.max

class RotateFunction {
    fun maxRotateFunction(nums: IntArray): Int {
        var sum = 0L
        var f = 0L
        val n = nums.size

        for (i in 0 until n) {
            sum += nums[i]
            f += i.toLong() * nums[i]
        }

        var maxVal = f;
        for (k in 1 until n) {
            f = f + sum - n.toLong() * nums[n - k];
            maxVal = max(maxVal, f)
        }

        return maxVal.toInt()
    }
}