package problem.bronze

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.pow
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cnt = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(cnt) {
        val (height, weight) = br.readLine().split(" ").map { it.toInt() }
        val bmi = getBMI(height, weight)

        sb.appendLine(
            when (height) {
                in 1..140 -> 6
                in 141 until 146 -> 5
                in 159 until 161 ->
                    if (bmi.toInt() in 16 until 35) 3 else 4
                in 161 until 204 ->
                    when {
                        bmi >= 20.0 && bmi < 25.0 -> 1
                        bmi >= 18.5 && bmi < 20.0 -> 2
                        bmi >= 25.0 && bmi < 30.0 -> 2
                        bmi >= 16.0 && bmi < 18.5 -> 3
                        bmi >= 30.0 && bmi < 35.0 -> 3
                        else -> 4
                    }
                else -> 4
            }
        )

    }
    print(sb.toString())

    br.close()
}

fun getBMI(height: Int, weight: Int): Double = weight / pow(height * 0.01, 2.0)