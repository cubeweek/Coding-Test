package problem.bronze

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) {
    var br = BufferedReader(InputStreamReader(System.`in`))
    var bw = BufferedWriter(OutputStreamWriter(System.out))

    var inputCnt = br.readLine().toInt()
    while (inputCnt-- > 0) {
        var input = br.readLine()
        bw.write("${input.get(0)}${input.get(input.length-1)}\n")
    }

    br.close()
    bw.flush()
    bw.close()
}