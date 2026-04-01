package problem.baekjoon.silver.s5

import java.util.StringTokenizer

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val n =  br.readLine().toInt()
    val st = StringTokenizer(br.readLine())
    val map = HashMap<Int, Int>()

    repeat (n) {
        val now = st.nextToken().toInt()
        if (map.containsKey(now)) map[now] = map[now]!! + 1
        else map[now] = 1
    }
    var answer = map.filter { it.value >= 2 }.count() * 2
    answer += map.filter { it.value == 1 }.count()
    println(answer)
}