package problem.leetcode.medium

class RotatedDigits {
    fun rotatedDigits(n: Int): Int {
        var answer = 0
        for (i in 1..n) {
            var singleCnt = 0
            var now = i
            var isPass = false
            while (now > 0) {
                when (now % 10) {
                    3,4,7 -> {
                        isPass = true
                        break
                    }
                    0,1,8 -> {}
                    else -> singleCnt++
                }
                now /= 10
            }
            if (isPass) continue
            else if (singleCnt > 0) answer++
        }

        return answer
    }
}