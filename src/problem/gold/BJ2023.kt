package problem.gold

import java.lang.StringBuilder
import kotlin.math.sqrt

val sb = StringBuilder()
var target = 1
fun main (args: Array<String>) {
    val primes = arrayOf(2,3,5,7)
    target = readln().toInt()

    primes.forEach {
        findPrime(it, 1)
    }

    print(sb.toString())
}

fun findPrime(num: Int, digits: Int) {
    if (target == digits) {
        if (isPrime(num)) sb.appendLine(num)
        return
    }
    for (i in 1..9 step 2) {
        if (!(digits > 1 && i == 5)
            && isPrime(num * 10 + i)) findPrime(num * 10 + i, digits + 1)
    }
}

fun isPrime(num: Int): Boolean {
    for (i in 2..sqrt(num.toDouble()).toInt()) {
        if (num % i == 0) return false
    }
    return true
}