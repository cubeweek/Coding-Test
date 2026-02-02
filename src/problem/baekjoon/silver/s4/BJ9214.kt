package problem.baekjoon.silver.s4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = ArrayList<String>()
    while (true) {
        val input = br.readLine() ?: break

        if ("0" == input) break
        list.add(input)
    }
    br.close()

    var bef = ""
    val now = StringBuilder()
    var chkDupNum = '-'
    var isWeird = -1
    for (i in 0 until list.size) {
        if (list[i].length % 2 == 1) continue

        bef = list[i]
        while (true) {
            now.clear()
            chkDupNum = '-'
            for (j in 0 until bef.length / 2) {
                val nowNum = bef[2 * j + 1]
                if (chkDupNum == nowNum) {
                    isWeird = i
                    break
                }
                repeat (bef[2 * j].digitToInt()) {
                    now.append(nowNum)
                }
                chkDupNum = nowNum
            }

            if (now.length % 2 == 1) {
                list[i] = now.toString()
                break
            } else if (bef == now.toString() || isWeird == i) {
                list[i] = bef
                break
            }
            bef = now.toString()
        }
    }
    val sb = StringBuilder(list.size * 100)
    for (idx in list.indices) sb.appendLine("Test ${idx + 1}: ${list[idx]}")
    print(sb)


}