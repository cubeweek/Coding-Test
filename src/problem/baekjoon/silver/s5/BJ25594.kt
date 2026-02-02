package problem.baekjoon.silver.s5

fun main(args: Array<String>) {
    val passTab = mapOf(
        'a' to "aespa", 'b' to "baekjoon", 'c' to "cau", 'd' to "debug", 'e' to "edge",
        'f' to "firefox", 'g' to "golang",  'h' to "haegang", 'i' to "iu", 'j' to "java",
        'k' to "kotlin",  'l' to "lol",  'm' to "mips",  'n' to "null",  'o' to "os",
        'p' to "python", 'q' to "query", 'r' to "roka", 's' to "solvedac", 't' to "tod",
        'u' to "unix", 'v' to "virus", 'w' to "whale", 'x' to "xcode", 'y' to "yahoo", 'z' to "zebra")

    val msg = readln()
    val msgLen = msg.length
    var isWrong = false
    var cur = 0
    val sb = StringBuilder(msg.length / 2)
    while (cur < msgLen) {
        val key = msg[cur]
        val mustBe = passTab[key] ?: break
        if (msgLen - cur+1 < mustBe.length) isWrong = true
        if (isWrong) break

        for (m in mustBe.indices) if (msg[cur++] != mustBe[m]) isWrong = true
        sb.append(key)
    }

    println( if (isWrong) "ERROR!" else "It's HG!\n$sb" )
}