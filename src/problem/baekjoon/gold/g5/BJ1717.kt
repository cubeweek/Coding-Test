package problem.baekjoon.gold.g5
import java.util.StringTokenizer

fun main (args: Array<String>) {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val setArr = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (setArr[x] != x) setArr[x] = find(setArr[x])
        return setArr[x]
    }

    fun union(a: Int, b: Int) {
        val rep = find(a)
        val chg = find(b)
        if (rep == chg) return
        setArr[chg] = rep
    }

    val sb = StringBuilder()
    repeat (m) {
        val st = StringTokenizer(br.readLine())
        val cmd = st.nextToken()
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if ("1" == cmd) {
            sb.appendLine(if (find(a) == find(b)) "YES" else "NO")
        } else {
            union(a, b)
        }
    }

    print(sb)
}
/*
// 최적화 방법 : 입력 최적화로 시간 줄이기
import java.io.DataInputStream
import java.lang.StringBuilder

private const val BUFFER_SIZE = 1 shl 16
private val input = DataInputStream(System.`in`)
private val buffer = ByteArray(BUFFER_SIZE)
private var bufferLen = 0
private var bufferPos = 0

private fun readByte(): Int {
    if (bufferPos >= bufferLen) {
        bufferLen = input.read(buffer, 0.also { bufferPos = it }, BUFFER_SIZE)
        if (bufferLen <= 0) return -1
    }
    return buffer[bufferPos++].toInt()
}

// 1717 전용으로 단순화: 공백 스킵 후 '0'~'9' 연속을 Int로 파싱(음수 처리 없음)
private fun nextInt(): Int {
    var c: Int
    do c = readByte() while (c <= 32) // space/newline skip

    var value = 0
    while (c > 32) { // digit sequence
        value = value * 10 + (c - '0'.code)
        c = readByte()
    }
    return value
}

fun main() {
    val n = nextInt()
    var m = nextInt()

    val parent = IntArray(n + 1) { it }
    val out = StringBuilder()

    fun find(x: Int): Int {
        if (parent[x] == x) return x
        val root = find(parent[x])
        parent[x] = root // path compression
        return root
    }

    fun union(x: Int, y: Int) {
        val rx = find(x)
        val ry = find(y)
        if (rx == ry) return
        // (원본 로직 유지) 작은 루트를 부모로
        if (rx < ry) parent[ry] = rx else parent[rx] = ry
    }

    while (m-- > 0) {
        val op = nextInt()   // 0: union, 1: find
        val a = nextInt()
        val b = nextInt()

        if (op == 0) {
            union(a, b)
        } else {
            out.append(if (find(a) == find(b)) "YES\n" else "NO\n")
        }
    }

    print(out.toString())
}*/