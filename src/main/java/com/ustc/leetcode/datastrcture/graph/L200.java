package com.ustc.leetcode.datastrcture.graph;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 */
public class L200 {

    /**
     * dfs 想当然认为上，左不用考虑
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfs(grid, visited, i, j, row, col);
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j, int row, int col) {
        if (i >= row || j >= col || j < 0 || i < 0) {
            return;
        }
        if (grid[i][j] == '0' || visited[i][j] == true) {
            return;
        }

        visited[i][j] = true;
        // 遍历所有邻接点， 因为是从上往下的，所有不用考虑上
        // 下
        dfs(grid, visited, i + 1, j, row, col);
        // 右
        dfs(grid, visited, i, j + 1, row, col);
        // 左
        dfs(grid, visited, i, j - 1, row, col);

        // 还真有上的
        dfs(grid, visited, i - 1, j, row, col);
    }
}
