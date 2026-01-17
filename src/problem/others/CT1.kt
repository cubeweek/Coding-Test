package problem.others

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var answer = 0

    val regex = Regex("(AAB+|BAB+A)+")
    val inputCnt = br.readLine().toInt()

    repeat (inputCnt) {
        val str = br.readLine()
        if (regex.matches(str)) answer++
    }

    br.close()
    print(answer)
}