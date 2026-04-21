package problem.leetcode.medium

class MinimizeHammingDistanceAfterSwapOperations {
    fun minimumHammingDistance(source: IntArray, target: IntArray, allowedSwaps: Array<IntArray>): Int {
        val n = source.size
        var parent = IntArray(n ) { it }
        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }
        fun union(a: Int, b: Int) {
            val rep = find(a)
            val chg = find(b)
            if (rep != chg) parent[chg] = rep
        }
        for (swap in allowedSwaps) union(swap[0], swap[1])

        val havingByParent = mutableMapOf<Int, MutableMap<Int, Int>>()
        for (i in 0 until n) {
            val key = find(i)
            val list = havingByParent.getOrPut(key) { mutableMapOf() }
            list[source[i]] = (list[source[i]] ?: 0) + 1
        }

        var diffCnt = n
        for (i in 0 until n) {
            val grp = havingByParent[find(i)] ?: continue
            val now = grp[target[i]] ?: continue
            if (now > 0) {
                grp[target[i]] = now - 1
                diffCnt--
            }
        }

        return diffCnt
    }
}