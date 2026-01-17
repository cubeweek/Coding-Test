package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val temp = IntArray(cnt)
    val radixSorter = List(10) { ArrayDeque<Int>() }


    var digit = 10
    repeat(cnt) {
        val input = br.readLine().toInt()
        radixSorter[input % digit].add(input)
    }

    var c = 0
    radixSorter.forEach {
        while (it.isNotEmpty()) {
            temp[c++] = it.pollFirst()
        }
    }

    while (digit < 100000) {
        radixSorter.forEach { it.clear() }

        temp.forEach {
            radixSorter[it % digit].add(it)
        }

        var i = 0
        radixSorter.forEach {
            while (it.isNotEmpty()) {
                temp[i++] = it.pollFirst()
            }
        }

        digit *= 10
    }

    print(temp.joinToString("\n"))


    br.close()
}