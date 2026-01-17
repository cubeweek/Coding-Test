package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayDeque

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val quest = ArrayDeque<Int>()

    for (i in 1..n) quest.add(br.readLine().toInt())

    var stack = Stack<Int>()
    var stackLogger = StringBuilder()
    var cursor = 1
    var canMake = ""

    while (quest.isNotEmpty()) {
        while (cursor <= quest.first()) {
            stack.push(cursor++)
            stackLogger.appendLine("+")
        }
        if (stack.isNotEmpty() && quest.first() == stack.peek()) {
            quest.removeFirst()
            stack.pop()
            stackLogger.appendLine("-")
        } else {
            canMake = "NO"
            break
        }
    }
    println(if ("NO" == canMake ) canMake else stackLogger.toString())
}