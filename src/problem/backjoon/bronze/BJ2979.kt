package problem.backjoon.bronze

fun main(args: Array<String>) {
    val input = readln().split(" ").map { it.toInt() }
    val feeTable = IntArray(4)
    val parkingLot = IntArray(101)

    for (i in input.indices) feeTable[i + 1] = input[i]

    repeat(3) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        for (i in from until to) {
            parkingLot[i]++
        }
    }

    var fee = 0
    parkingLot.forEach {
        fee += feeTable[it] * it
    }

    println(fee)
}