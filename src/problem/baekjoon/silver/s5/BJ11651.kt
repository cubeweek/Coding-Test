package problem.baekjoon.silver.s5

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Coordinate(val x: Int, val y: Int): Comparable<Coordinate> {
    override fun compareTo(other: Coordinate): Int {
        return if (this.y != other.y) this.y - other.y
            else this.x - other.x
    }

}
fun main (args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val cnt = br.readLine().toInt()
    val coordList = ArrayList<Coordinate>(cnt)
    val sb = StringBuilder()

    repeat(cnt) {
        val st = StringTokenizer(br.readLine())
        coordList.add(Coordinate(st.nextToken().toInt(), st.nextToken().toInt()))
    }

    coordList.sort()
    for (c in coordList) {
        sb.append(c.x).append(" ").appendLine(c.y)
    }

    print(sb.toString())
}