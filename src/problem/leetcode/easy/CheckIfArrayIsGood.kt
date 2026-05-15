package problem.leetcode.easy

class CheckIfArrayIsGood {
    fun isGood(nums: IntArray): Boolean {val n = nums.size - 1
        if (n == 0) return false

        nums.sort()

        for (i in 0 until n - 1) {
            if (nums[i] != i + 1) return false
        }

        return nums[n - 1] == n && nums[n] == n
    }
}