package problem.baekjoon.bronze.b3

fun main(args: Array<String>) {
    val n = readln().toInt()

    var sb = StringBuilder("int a;\nint *ptr = &a;\n")
    var star = StringBuilder("**")

    if (n >= 2) sb.append("int ${star}ptr2 = &ptr;\n")

    for (i in 3..n) {
        star.append("*")
        sb.append("int ${star}ptr$i = &ptr${i-1};\n")
    }
    println(sb)
}