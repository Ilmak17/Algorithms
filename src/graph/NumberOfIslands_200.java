package graph;

/*
 * LeetCode Problem 200: Number Of Islands
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 *  return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *  You may assume all four edges of the grid are all surrounded by water.
 */


public class NumberOfIslands_200 {
    public int numIslands(char[][] grid) {
        int maxNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    maxNum++;
                }
            }
        }

        return maxNum;
    }

    private void dfs(char[][] grid, int r, int c) {
        if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length) {
            return;
        }
        if (grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';

        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
    }
}
