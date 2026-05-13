package problem.leetcode.easy

class SeparateTheDigitsInAnArray {
    fun separateDigits(nums: IntArray): IntArray {
        val sb = StringBuilder()
        for (n in nums) {
            sb.append(n)
        }

        return sb.toString().toCharArray().map { it.toString().toInt() }.toIntArray()
    }
}