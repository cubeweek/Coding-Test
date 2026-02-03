package problem.baekjoon.silver.s5

import java.math.BigInteger

fun main(args: Array<String>) {
    var target = readln().toInt()
    var calcFac = BigInteger.ONE


    while (target > 0) {
        calcFac *= BigInteger(target.toString())
        --target
    }

    var cnt = 0
    val facArr = calcFac.toString().toCharArray()
    for (i in facArr.size-1 downTo 0) {
        if ('0' == facArr[i]) ++cnt
        else break
    }
    print(cnt)
}