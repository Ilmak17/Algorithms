package graph;

/*
 * LeetCode Problem 286: Walls And Gates
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a m×n m×n 2D grid initialized with these three possible values:
 * -1 - A water cell that can not be traversed.
 * 0 - A treasure chest.
 * INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
 * Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest than the value should remain INF.
 * Assume the grid can only be traversed up, down, left, or right.
 */

public class WallsAndGates_286 {
    public int[][] islandsAndTreasure(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == Integer.MAX_VALUE) {
                    grid[i][j] = dfs(grid, i, j, new boolean[grid.length][grid[0].length]);
                }
            }
        }

        return grid;
    }

    private int dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if (Math.min(r, c) < 0 || r >= grid.length || c >= grid[0].length) {
            return Integer.MAX_VALUE;
        }

        if (visited[r][c]) {
            return Integer.MAX_VALUE;
        }

        if (grid[r][c] == -1) {
            return Integer.MAX_VALUE;
        }

        if (grid[r][c] == 0) {
            return 0;
        }

        visited[r][c] = true;
        int c1 = dfs(grid, r + 1, c, visited);
        int c2 = dfs(grid, r - 1, c, visited);
        int c3 = dfs(grid, r, c + 1, visited);
        int c4 = dfs(grid, r, c - 1, visited);

        visited[r][c] = false;

        int minDist = Math.min(Math.min(c1, c2), Math.min(c3, c4));
        if (minDist != Integer.MAX_VALUE) {
            grid[r][c] = minDist + 1;
        }

        return grid[r][c];
    }
}
