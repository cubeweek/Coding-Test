package problem.baekjoon.bronze;

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val students = IntArray(30) { 0 }

    var inputCnt = 28;
    while (inputCnt-- > 0) ++students[Integer.parseInt(br.readLine()) - 1];

    for (i in 0..29) {
        if (students[i] == 0) println(i + 1)
    }

    br.close();
}