package graph;

/*
 * LeetCode Problem 695: Max Area of Island
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.)
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */

public class MaxAreaOfIslands_695 {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int maxLen = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    int len = dfs(grid, visited, i, j);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {
        if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length) {
            return 0;
        }
        if (visited[r][c] || grid[r][c] == 0) {
            return 0;
        }
        visited[r][c] = true;

        return 1 + dfs(grid, visited, r + 1, c) +
                dfs(grid, visited, r - 1, c) +
                dfs(grid, visited, r, c + 1) +
                dfs(grid, visited, r, c - 1);
    }
}
