package problem.baekjoon.bronze.b1

fun main(args: Array<String>) {
    val a = readln().toCharArray().map { it.digitToInt() }
    val b = readln().toCharArray().map { it.digitToInt() }
    
    var len = a.size + b.size
    val temp1 = IntArray(len)
    for (i in 0 until a.size) {
        temp1[i*2] = a[i]
        temp1[i*2+1] = b[i]
    }

    val temp2 = IntArray(len - 1)
    while (len > 2) {
        val from = if (len % 2 == 0) temp1 else temp2
        val to = if (len % 2 == 1) temp1 else temp2
        
        for (i in 0 until len - 1) {
            to[i] = (from[i] + from[i+1]) % 10
        }
        len--
    }
    println("${temp1[0]}${temp1[1]}")
}