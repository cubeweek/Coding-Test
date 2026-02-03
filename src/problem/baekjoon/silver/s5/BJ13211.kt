package problem.baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var stolenPassportCnt = 0

    val stolenCnt = br.readLine().toInt()
    val stolen = HashMap<Char, ArrayList<String>>()
    repeat (stolenCnt) {
        val passport = br.readLine()
        if (!stolen.containsKey(passport[0])) stolen[passport[0]] = ArrayList()
        stolen[passport[0]]?.add(passport.substring(1))
    }

    val checkCnt = br.readLine().toInt()
    repeat (checkCnt) {
        val passport = br.readLine()
        if (stolen[passport[0]]?.contains(passport.substring(1)) == true) stolenPassportCnt++
    }

    println(stolenPassportCnt)
}