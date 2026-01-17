package problem.backjoon.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        var input = br.readLine()
        if (input.isNullOrBlank()) break;
        else bw.write(input+"\n")
    }

    br.close()
    bw.flush()
    bw.close()
}