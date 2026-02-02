package problem.baekjoon.silver.s1

fun main(args: Array<String>) {
    fun checkPalindrome(prime: Int):Boolean {
        val primeStr = prime.toString()
        val primeLen = primeStr.length
        for (i in 0 until primeLen/2) {
            if (primeStr[i] != primeStr[primeLen - i - 1]) return false
        }
        return true
    }

    val n = readln().toInt()
    val primes = BooleanArray(1_003_002)
    primes[0] = true
    primes[1] = true

    for (i in 2..1001) { // 1003002 -> n의 최대치인 100만의 최소 팰린드롬&소수 재곱근
        if (primes[i]) continue
        for (j in i*i..1_003_001 step i) {
            primes[j] = true
        }
    }

    for (t in n..1_003_001) {
        if (!primes[t] && checkPalindrome(t)) {
            println(t)
            break
        }
    }
}