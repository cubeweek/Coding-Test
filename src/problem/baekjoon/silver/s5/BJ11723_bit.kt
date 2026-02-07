package problem.baekjoon.silver.s5

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    var mask = 0
    val cmdCnt = br.readLine().toInt()

    val sb = StringBuilder()
    repeat(cmdCnt) {
        val now = br.readLine()

        when (now[0]) {
            'a' ->
                mask = if ('d' == now[1]) mask or (1 shl now.substring(4).toInt())
                    else (1 shl 21) - 2
            'r' -> mask = mask and (1 shl now.substring(7).toInt()).inv()
            'c' -> sb.append(if ((mask and (1 shl now.substring(6).toInt())) != 0) 1 else 0).append("\n")
            't' -> mask = mask xor (1 shl now.substring(7).toInt())
            'e' -> mask = 0
        }
    }

    println(sb)
}