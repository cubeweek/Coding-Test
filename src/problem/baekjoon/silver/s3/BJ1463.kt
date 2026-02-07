package problem.baekjoon.silver.s3

fun main(args: Array<String>) {
    var n = readln().toInt()
    var answer = 0

    while (n != 1) {
        if (n % 3 == 0) n /= 3
        else if (n % 2 == 0) n /= 2
        else n -= 1
        answer++
    }

    print(answer)

}