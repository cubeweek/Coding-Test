package problem.leetcode.medium

import kotlin.math.max
import kotlin.math.min

class MinimumMovesToMakeArrayComplementary {
    fun minMoves(nums: IntArray, limit: Int): Int {
        val n = nums.size
        // 합계가 가질 수 있는 최대 범위는 2 * limit
        // 차분 배열(delta)을 생성 (인덱스 계산 편의를 위해 크기를 넉넉히 잡음)
        val delta = IntArray(2 * limit + 2)

        for (i in 0 until n / 2) {
            val a = nums[i]
            val b = nums[n - 1 - i]

            // 1. 기본적으로 모든 합계에 대해 2번 이동이 필요하다고 가정
            // [2, 2 * limit] 범위 전체에 +2를 하는 효과
            delta[2] += 2
            delta[2 * limit + 1] -= 2

            // 2. 1번만 이동해도 되는 범위를 계산해서 비용을 1 줄임 (-1)
            // 범위: [min(a, b) + 1, max(a, b) + limit]
            val minSumAllowed = min(a, b) + 1
            val maxSumAllowed = max(a, b) + limit
            delta[minSumAllowed] -= 1
            delta[maxSumAllowed + 1] += 1

            // 3. 0번 이동해도 되는 지점(현재 합계)은 추가로 비용을 1 더 줄임 (-1)
            // 지점: a + b
            val currentSum = a + b
            delta[currentSum] -= 1
            delta[currentSum + 1] += 1
        }

        var minMoves = n // 최대 이동 횟수는 n (모든 숫자를 다 바꾸는 경우)
        var currentMoves = 0

        // 누적 합을 구하며 최솟값 갱신
        for (i in 2..2 * limit) {
            currentMoves += delta[i]
            minMoves = min(minMoves, currentMoves)
        }

        return minMoves
    }
}