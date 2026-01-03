package problem.bronze

fun plusOne(digits: IntArray): IntArray {
    val digitLen = digits.size - 1
    var isOver = true

    if (digits[digitLen] != 9) {
        digits[digitLen] += 1
        return digits
    }

    for (i in digitLen downTo 0) {
        if (digits[i] != 9) {
            digits[i] += 1
            isOver = false
        }
    }

    if (isOver) {
        val newDigits = IntArray(digitLen + 2)
        newDigits[0] = 1
        for (i in 1..digitLen+1) newDigits[i] = 0
        return newDigits
    } else {
        return digits
    }
}