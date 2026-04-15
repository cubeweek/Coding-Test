package problem.baekjoon.silver.s3

fun main(args: Array<String>) {
    val key = readln()
    val sortedKey = key.toCharArray().sorted()
    val encStr = readln()

    val keyLen = key.length
    val strLen = encStr.length
    val bundleCnt = strLen / keyLen

    val strSheet = Array (keyLen) { CharArray(bundleCnt) }

    for (i in 0 until strLen) strSheet[i / bundleCnt][i % bundleCnt] = encStr[i]

    val decInfo = IntArray(keyLen)
    val isChk = BooleanArray(keyLen)
    for (k in 0 until keyLen) {
        var cur = 0
        while (key[k] != sortedKey[cur] || isChk[cur]) cur++
        decInfo[k] = cur
        isChk[cur] = true
    }

    val sb = StringBuilder()
    for (i in 0 until bundleCnt) {
        for (d in decInfo) {
            sb.append(strSheet[d][i])
        }
    }
    println(sb.toString())
}