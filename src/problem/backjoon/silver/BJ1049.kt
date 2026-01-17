package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (lost, brandCnt) = br.readLine().split(" ").map { it.toInt() }
    val bundle = lost / 6
    val remain = lost % 6
    val bundleOfSet = bundle + if (remain != 0) 1 else 0

    var cheapBySet = Int.MAX_VALUE
    var cheapByPiece = Int.MAX_VALUE
    repeat (brandCnt) {
        val (set, piece) = br.readLine().split(" ").map { it.toInt() }
        if (cheapBySet > set) cheapBySet = set
        if (cheapByPiece > piece) cheapByPiece = piece
    }

    val buySet = cheapBySet * bundleOfSet
    val buyPiece = cheapByPiece * lost
    val buyMix = cheapBySet * bundle + cheapByPiece * remain

    print(minOf(buySet, buyPiece, buyMix))
}