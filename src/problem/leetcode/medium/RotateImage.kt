package problem.leetcode.medium
/*
fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size

    // 1. 행렬 전치 (Transpose)
    // 사실: matrix[i][j]와 matrix[j][i]를 교환합니다.
    for (i in 0 until n) {
        for (j in i until n) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    // 2. 각 행 뒤집기 (Reverse)
    // 사실: 행의 요소를 좌우 반전시키면 90도 회전이 완성됩니다.
    for (i in 0 until n) {
        matrix[i].reverse()
    }
}
*/
fun rotate(matrix: ArrayList<Array<Int>>): Unit {
    var n = matrix.size
    var box = 0
    val way = arrayOf(1 to 0, 0 to -1, -1 to 0, 0 to 1)

    for (v in 0 until n) {
        val temp = matrix[v].sliceArray(v until matrix.size - v)
        var y = 0
        var x = n - 1
        for (w in 0..3) {
            for (i in 0 until n) {
                box = matrix[y][x]
                matrix[y][x] = temp[i]
                temp[i] = box

                y += way[w].first
                x += way[w].second
            }
        }
        --n
    }
    for (i in 0 until n) println(matrix[i].contentToString())
}

fun main(args: Array<String>) {
    rotate(arrayListOf(arrayOf(5,1,9,11), arrayOf(2,4,8,10),arrayOf(13,3,6,7),arrayOf(15,14,12,16)))
}