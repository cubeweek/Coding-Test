package problem.backjoon.silver

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    quickSortUntilKth(arr, 0, n - 1, k - 1)
    println(arr[k-1])

    br.close()
}

tailrec fun quickSortUntilKth(a: IntArray, s: Int, e: Int, k: Int) {
    if (s < e) {
        val pivot = partition(a, s, e)

        if (pivot == k) return // k번쨰 수가 pivot이면 더 이상 구할 필요 없음
        else if (k < pivot) quickSortUntilKth(a, s, pivot - 1, k) // k가 pivot보다 작으면 왼쪽 그룹만 정렬 수행하기
        else quickSortUntilKth(a, pivot + 1, e, k) // k가 pivot보다 크면 오른쪽 그룹만 정렬 수행하기
    }
}

// 배열을 분할하고 피봇 위치 반환 (일반적인 퀵소트 partition 함수)
fun partition(a: IntArray, s: Int, e: Int): Int {
    // 두 개 원소인 경우 비교 후 swap
    if (s + 1 == e) {
        if (a[s] > a[e]) swap(a, s, e)
        return e
    }
    val m = (s + e) / 2
    swap(a, s, m) // 중앙 값을 1번째 요소로 이동하기

    val pivot = a[s]
    var i = s + 1
    var j = e
    while (i <= j) {
        while (j >= s + 1 && pivot < a[j]) j-- // Pivot보다 작은 수가 나올 때까지
        while (i <= e && pivot > a[i]) i++ // Pivot보다 큰 수가 나올 때까지
        if (i <= j) swap(a, i++, j--)
    }

    // Pivot 데이터를 나눠진 두 그룹의 경계 index에 저장하기
    a[s] = a[j]
    a[j] = pivot
    return j
}

fun swap (a: IntArray, i: Int, j: Int) {
    val temp = a[i]
    a[i] = a[j]
    a[j] = temp
}