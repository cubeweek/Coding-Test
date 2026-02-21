package problem.baekjoon.gold.g5

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val S = br.readLine()
    val T = StringBuilder(br.readLine())

    val sLen = S.length
    var target = T.length - 1
    while (target >= sLen) {
        when (T[target]) {
            'A' -> T.deleteAt(target)
            'B' -> T.deleteAt(target).reverse()
        }
        target--
    }

    println( if (S == T.toString()) 1 else 0 )
}