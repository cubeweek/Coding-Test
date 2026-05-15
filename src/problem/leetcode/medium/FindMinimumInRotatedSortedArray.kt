package problem.leetcode.medium

class FindMinimumInRotatedSortedArray {
    fun findMin(nums: IntArray): Int {
        var minNum = Int.MAX_VALUE
        for (n in nums) {
            if (n < minNum) minNum = n
        }
        return minNum
    }
}