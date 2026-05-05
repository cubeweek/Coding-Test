package problem.leetcode.easy

class RotateString {
    fun rotateString(s: String, goal: String): Boolean {
        if (s.length != goal.length) return false

        val doubledS = s + s
        return doubledS.contains(goal)
    }
}