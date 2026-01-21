package problem.baekjoon.gold.g2

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/*
    합동식     : ≡
    베주 항등식(Bézout's Identity) : ax + by = gcd(a,b)
    확장된 유클리드 호제법(Extended Euclidean Algorithm) :
        ax + by = c일 때, c % gcd(a,b) = 0인 경우(아닌 경우 성립하지 않음!)
        1. gcd(a, b)의 몫 반복 계산 구간에서 구한 몫(q)과 이전의 a(a'), b(b') 값을 역산 (맨 처음엔 1, 0으로 지정)
        2. 이 때 역산 식은 x = y' / y = x'-y' * q

*/
data class EE(val g: Long, val x: Long, val y: Long)
private fun extEuclidean(a: Long, b: Long):EE {
    if (b == 0L) return EE(a, 1L, 0L)
    val r = extEuclidean(b, a % b)
    val x = r.y
    val y = r.x - (a / b) * r.y
    return EE(r.g, x, y)
}

// % 연산 시 나머지가 -일 경우에 대해 보정
private fun safeMod(x: Long, mod: Long): Long = ((x % mod) + mod) % mod
fun main(args: Array<String>) {
    val st = StringTokenizer(BufferedReader(InputStreamReader(System.`in`)).readLine())
    val n = st.nextToken().toLong()
    val a = st.nextToken().toLong()

    /* (a + b) % n = 0
        -> (a + b) ≡ 0 ( % n )
        -> b ≡ -a ( % n )
        -> b ≡ n - a ( % n ) */
    val invAdd = safeMod(n - a, n) // b ≡ (n - a) % n (중 최소의 b를 구함)

    val ee = extEuclidean(a, n)

    /* (a * b) % n = 1
        -> ab ≡ 1 ( % n )
        -> ab - 1 ≡ 0 ( % n )
        -> n | (ab - 1)
        -> ab - 1 = kn
        -> ab - kn = 1
        -> ab + n(-k) = 1
     */
    val invMul = if (ee.g != 1L) - 1L else safeMod(ee.x, n)

    print("$invAdd $invMul")
}