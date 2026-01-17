package problem.backjoon.bronze

fun main (args: Array<String>) {
    val str = readln()
    val strLen = str.length
    val copyCnt = readln().toLong()
    val halfPos = strLen / 2 + strLen % 2
    var st = halfPos  - if (strLen % 2 == 0) 1 else 2
    var ed = halfPos

    var isPalindrome = true
    while (st >= 0) {
        if (str[st--] != str[ed++]) {
            isPalindrome = false
            break;
        }
    }

    print(if (isPalindrome) "YES" else "NO")
}