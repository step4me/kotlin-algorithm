package graph

/**
 * 200. Number of Islands
 * https://leetcode.com/problems/number-of-islands/
 */
object IslandsSize {
    fun count(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        var islandsSize = 0
        val gridSize = grid.size
        for (rowIdx in 0 until gridSize) {
            val elementSize = grid[0].size
            for (colIdx in 0 until elementSize) {
                if (grid[rowIdx][colIdx] == '1') {
                    searchAdjacentIsland(grid, rowIdx, colIdx)
                    islandsSize++
                }
            }
        }
        return islandsSize
    }

    private fun searchAdjacentIsland(grid: Array<CharArray>, rowIdx: Int, colIdx: Int) {
        // Backtracking
        if (rowIdx < 0 || rowIdx >= grid.size ||
            colIdx < 0 || colIdx >= grid[0].size ||
            grid[rowIdx][colIdx] != '1') return
        // You don't need to create a new array for saving visited position
        grid[rowIdx][colIdx] = '0'
        searchAdjacentIsland(grid, rowIdx, colIdx + 1)
        searchAdjacentIsland(grid, rowIdx, colIdx - 1)
        searchAdjacentIsland(grid, rowIdx - 1, colIdx)
        searchAdjacentIsland(grid, rowIdx + 1, colIdx)
    }
}

fun main() {
    // '1' : land, '0' : water
    val input1 = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(IslandsSize.count(input1)) // output 1
    val input2 = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )
    println(IslandsSize.count(input2)) // output 3
}