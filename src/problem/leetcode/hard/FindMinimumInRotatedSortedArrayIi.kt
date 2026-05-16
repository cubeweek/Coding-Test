package problem.leetcode.hard

class FindMinimumInRotatedSortedArrayIi {
    fun findMin(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        for (n in nums) if (min > n) min = n
        return min
    }
}