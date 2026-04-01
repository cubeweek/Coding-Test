package problem.baekjoon.bronze.b4

fun main(args: Array<String>) {
    val promises = arrayOf("Never gonna give you up"
            ,"Never gonna let you down"
            ,"Never gonna run around and desert you"
            ,"Never gonna make you cry"
            ,"Never gonna say goodbye"
            ,"Never gonna tell a lie and hurt you"
            ,"Never gonna stop")

    val n = readln().toInt()

    var answer = "No"
    repeat(n) {
        if (!promises.contains(readln())) {
            answer = "Yes"
        }
    }
    println(answer)
}