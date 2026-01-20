package problem.baekjoon.bronze.b1

fun main (args: Array<String>) {
    val strArr = Array<String>(3) { "" }

    for (i in 0..2) {
        strArr[i] = readln()
    }

    var answer = 0
    strArr.forEachIndexed() { i, v ->
        if ('F' != v[0] && 'B' != v[0]) {
            answer = v.toInt() + (3 - i)
            return@forEachIndexed
        }
    }

    println(getFizzBuzz(answer))
}

fun getFizzBuzz(num: Int): String =
    if(num % 3 == 0) {
        if (num % 5 == 0) "FizzBuzz" else "Fizz"
    } else {
        if (num % 5 == 0) "Buzz" else num.toString()
    }