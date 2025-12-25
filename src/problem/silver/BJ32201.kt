package problem.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val result = LinkedHashMap<String, Int>(br.readLine().toInt())
    val shoot = br.readLine().split(" ")
    br.readLine().split(" ").mapIndexed() { i, v -> result.put(v, i + 1) }
    shoot.mapIndexed() { i, v -> result.put(v, i + 1 - result[v]!!) }

    val answer = ArrayList<String>()
    var first = Int.MIN_VALUE

    result.forEach() {
        if (it.value < first) return@forEach
        else if (it.value > first) {
            answer.clear()
            first = it.value
        }
        answer.add(it.key)
    }


    println(answer.joinToString(" "))
}