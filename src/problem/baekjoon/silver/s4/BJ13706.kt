package problem.baekjoon.silver.s4

import java.math.*

private val ZERO = BigInteger.ZERO

private fun getSqrtByBabylonian(n: BigInteger): BigInteger {
    if (n == ZERO) return ZERO
    // 초기 추정: 2^(bitLength/2)
    var x = ZERO.setBit(n.bitLength() / 2)
    var prev = ZERO

    while (x != prev) {
        prev = x
        x = x.add(n.divide(x)).shiftRight(1)   // (x + n/x) / 2
    }
    return x
}

fun main(args: Array<String>) {
    val n = BigInteger(readln())
    print(getSqrtByBabylonian(n))
}