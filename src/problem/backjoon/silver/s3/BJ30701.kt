package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val info = br.readLine().split(" ")
    val cnt = info[0].toInt()
    var clearCnt = 0
    var power = info[1].toLong()
    val monsterFloor = PriorityQueue<Long>()
    val weaponFloor = PriorityQueue<Long>()

    repeat (cnt) {
        val floor = br.readLine().split(" ").map { it.toLong() }

        if (1L == floor[0]) monsterFloor.add(floor[1])
        else weaponFloor.add(floor[1])
    }

    while (true) {
         if (monsterFloor.isNotEmpty() && power > monsterFloor.peek()) {
             power += monsterFloor.poll()
             clearCnt++
         } else if (weaponFloor.isNotEmpty()) {
             power *= weaponFloor.poll()
             clearCnt++
         } else break
    }

    println(clearCnt)
}