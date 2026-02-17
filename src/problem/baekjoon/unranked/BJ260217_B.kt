package problem.baekjoon.unranked

import java.util.Scanner
import kotlin.math.pow

fun main() {
    val sc = Scanner(System.`in`)
    if (!sc.hasNextInt()) return

    val n = sc.nextInt()
    val p = sc.nextDouble() // 하늘이 명중률
    val q = sc.nextDouble() // 푸르매 명중률

    // 이항 계수 (Combination) 미리 계산
    val comb = Array(21) { DoubleArray(21) }
    for (i in 0..20) {                      
        comb[i][0] = 1.0
        for (j in 1..i) {
            comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j]
        }
    }

    // 특정 명중률 prob으로 총 total발 중 k발 맞힐 확률
    fun getProb(total: Int, k: Int, prob: Double): Double {
        if (k > total) return 0.0
        return comb[total][k] * prob.pow(k) * (1 - prob).pow(total - k)
    }

    var maxExpectation = 0.0

    // 하늘이가 쏠 수 있는 발 수 x를 0부터 n까지 완전 탐색
    for (x in 0..n) {
        var currentE = 0.0

        for (i in 0..n) { // 푸르매가 i발 명중
            val probI = getProb(n, i, q)
            if (probI == 0.0) continue

            for (j in 0..x) { // 하늘이가 j발 명중
                if (i + j <= n) {
                    val probJ = getProb(x, j, p)
                    currentE += (i + j) * probI * probJ
                }
            }
        }

        if (currentE > maxExpectation) {
            maxExpectation = currentE
        }
    }

    // 결과 출력 (소수점 자릿수는 문제 요구사항에 따라 조절 가능)
    println("%.10f".format(maxExpectation))
}