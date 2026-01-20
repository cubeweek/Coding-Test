package problem.baekjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args : Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var coldestCity = ""
    var coldestTemp = Int.MAX_VALUE
    while (true) {
        val (city, temp) = br.readLine().split(" ")

        if (temp.toInt() < coldestTemp) {
            coldestTemp = temp.toInt()
            coldestCity = city
        }

        if ("Waterloo" == city) break
    }

    print(coldestCity)
    br.close()
}