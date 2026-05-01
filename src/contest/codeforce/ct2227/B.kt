package contest.codeforce.ct2227

fun main(args: Array<String>) {
    val br = System.`in`.bufferedReader()

    val testCnt = br.readLine().toInt()
    val sb = StringBuilder()

    repeat(testCnt) {
        val n = br.readLine().toInt()
        val str = br.readLine()
        var left = 0
        var right = 0
        for (s in str) if (s == '(') left++ else right++
        sb.append("${ if (left == right) "YES" else "NO" }\n")
    }
    println(sb)
}