package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var inputCnt = br.readLine().toInt()
    val list = ArrayList<Member>()

    while (inputCnt-- > 0) {
        val input = br.readLine().split(" ")
        list.add(Member(input[0].toInt(), input[1]))
    }

    list.sortBy { it.age }
    list.forEach { println("${it.age} ${it.name}") }

    br.close()
}

class Member(var age: Int, var name: String)