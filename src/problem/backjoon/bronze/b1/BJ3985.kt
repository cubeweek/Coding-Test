package problem.backjoon.bronze.b1

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val cakeLen = br.readLine().toInt()
    val perCnt = br.readLine().toInt()
    val cake = IntArray(cakeLen + 1)
    val person = IntArray(perCnt + 1)

    var expectCnt = Int.MIN_VALUE
    var expect1st = Int.MIN_VALUE
    for (i in 1..perCnt) {
        val (st, ed) = br.readLine().split(" ").map { it.toInt() }
        for (s in st..ed) {
            if (cake[s] == 0) cake[s] = i
        }
        if (expectCnt < ed - st) {
            expectCnt = ed - st
            expect1st = i
        }
    }
    cake.forEach {
        person[it]++
    }

    var actualMax = Int.MIN_VALUE
    var actual1st = Int.MIN_VALUE
    for (i in 1..perCnt) {
        if (person[i] > actualMax) {
            actualMax = person[i]
            actual1st = i
        }
    }

    println(expect1st)
    println(actual1st)

    br.close()
}