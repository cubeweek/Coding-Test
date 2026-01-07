package problem.silver

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val sb = StringBuilder()
    val formula = readln()

    var cur = 0
    for (i in 0 until formula.length) {
        if (')' == formula[i]) {
            sb.append(formula.substring(cur, i))
            when (formula[i-1]) {
                '(' -> sb.append(1)
                ')' -> sb.append("+1")
            }
            cur = i
        } else {
            if (formula[cur] == ')') {
                sb.append(")+")
                cur = i
            }
        }
    }
    sb.append(formula.substring(cur, formula.length))

    print(sb.toString())
}