package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader

// 유클리드 호제법
fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (a, b) = br.readLine().split(" ").map { it.toInt() }

    if (a == b) {
        println(a)
        println(a)
    } else {
        if (a < b) {
            val temp = a
            a = b
            b = temp
        }

        val gcd = euclidean(a, b)
        val lcm = (a * b) / gcd // 최소공배수(Least Common Multiple) 구하기 -> A x B / GCD
        println(gcd)
        println(lcm)
    }
    br.close()
}

// 최대공약수(Greatest Common Divisor) 구하기 -> 유클리드 호제법
fun euclidean(a: Int, b: Int): Int {
    if (b == 0) return a
    return euclidean(b, a % b)
}