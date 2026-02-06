package problem.baekjoon.gold.g4

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (person, party) = br.readLine().split(" ").map { it.toInt() }
    val checker = IntArray(person + 1) { it }

    fun find(x: Int): Int {
        if (checker[x] != x) checker[x] = find(checker[x])
        return checker[x]
    }

    fun union(a: Int, b: Int) {
        val rep = find(a)
        val chg = find(b)
        if (rep != chg) checker[chg] = rep
    }

    val stz = StringTokenizer(br.readLine())
    val righteousCnt = stz.nextToken().toInt()
    if (0 == righteousCnt) {
        print(party)
        return
    }

    val righteous = IntArray(righteousCnt)
    for (i in 0 until righteousCnt) {
        righteous[i] = stz.nextToken().toInt()
        union(0, righteous[i])
    }

    val partyList = ArrayList<IntArray>()
    repeat (party) {
        val st = StringTokenizer(br.readLine())
        val cnt = st.nextToken().toInt()

        val part = IntArray(cnt)
        for (i in 0 until cnt) {
            val now = st.nextToken().toInt()
            part[i] = now
            union(part[0], part[i])
        }

        partyList.add(part)
    }

    var answer = party
    val standard = find(righteous[0])
    for (p in partyList) if (standard == find(p[0])) answer--

    println(answer)
}