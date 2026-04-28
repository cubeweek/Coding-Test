package problem.leetcode.medium

class CheckIfThereIsAValidPathInAGrid {
    fun hasValidPath(grid: Array<IntArray>): Boolean {
        val mapY = grid.size
        val mapX = grid[0].size
        val parents = IntArray(mapX * mapY) { it }

        fun find(i: Int): Int {
            if (parents[i] == i) return i
            parents[i] = find(parents[i])
            return parents[i]
        }

        fun union(a: Int, b: Int) {
            val rootA = find(a)
            val rootB = find(b)
            if (rootA != rootB) parents[rootA] = rootB
        }

        val directions = mapOf(
            1 to arrayOf(0 to -1, 0 to 1),
            2 to arrayOf(-1 to 0, 1 to 0),
            3 to arrayOf(0 to -1, 1 to 0),
            4 to arrayOf(0 to 1, 1 to 0),
            5 to arrayOf(0 to -1, -1 to 0),
            6 to arrayOf(0 to 1, -1 to 0)
        )

        for (y in 0 until mapY) {
            for (x in 0 until mapX) {
                val currentType = grid[y][x]
                for ((dy, dx) in directions[currentType]!!) {
                    val ny = y + dy
                    val nx = x + dx

                    if (ny in 0 until mapY && nx in 0 until mapX) {
                        val nextType = grid[ny][nx]
                        val canConnect = directions[nextType]!!.any { it.first == -dy && it.second == -dx }

                        if (canConnect) {
                            union(y * mapX + x, ny * mapX + nx)
                        }
                    }
                }
            }
        }

        return find(0) == find((mapY - 1) * mapX + (mapX - 1))
    }
}