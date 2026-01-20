package problem.backjoon.platinum.p5

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val temp = IntArray(n)
    var answer = 0L

    fun mergeSort(s: Int, e: Int) {
        if (e - s < 1) return
        val mid = (s + e) / 2
        mergeSort(s, mid)
        mergeSort(mid + 1, e)

        for (i in s..e) temp[i] = arr[i]

        var k = s
        var left = s
        var right = mid + 1

        while (left <= mid && right <= e) {
            if (temp[left] > temp[right]) {
                arr[k++] = temp[right++]
                answer += (right - k)
            } else {
                arr[k++] = temp[left++]
            }
        }
        while (left <= mid) arr[k++] = temp[left++]
        while (right <= e) arr[k++] = temp[right++]
    }

    mergeSort(0, n - 1)
    println(answer)
}
