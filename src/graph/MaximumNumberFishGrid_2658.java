package graph;

/*
 * LeetCode Problem 2658: Maximum Number of Fish in a Grid
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
 * A land cell if grid[r][c] = 0, or
 * A water cell containing grid[r][c] fish, if grid[r][c] > 0.
 * A fisher can start at any water cell (r, c) and can do the following operations any number of times:
 * Catch all the fish at cell (r, c), or
 * Move to any adjacent water cell.
 * Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally,
 * or 0 if no water cell exists.
 * An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.
 */

public class MaximumNumberFishGrid_2658 {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int findMaxFish(int[][] grid) {
        int maxFish = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0) {
                    maxFish = Math.max(dfs(grid, i, j), maxFish);
                }
            }
        }

        return maxFish;
    }

    private int dfs(int[][] grid, int r, int c) {
        if (r >= grid.length || c >= grid[0].length || Math.min(r, c) < 0 || grid[r][c] == 0) {
            return 0;
        }

        int counter = grid[r][c];
        grid[r][c] = 0;
        for (int[] dir : DIRECTIONS) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            counter += dfs(grid, nr, nc);
        }

        return counter;
    }
}
