package dp;

/*
 * LeetCode Problem 64: Minimum Path Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
 *  which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 */

import java.util.Arrays;

public class MinimumPathSum_64 {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] prev = new int[cols];
        Arrays.fill(prev, Integer.MAX_VALUE / 2);

        for (int r = 0; r < rows; r++) {
            int[] tmp = new int[cols];
            Arrays.fill(tmp, Integer.MAX_VALUE / 2);

            for (int c = 0; c < cols; c++) {
                if (r == 0 && c == 0) {
                    tmp[0] = grid[0][0];
                    continue;
                }

                int up   = prev[c];
                int left = c > 0 ? tmp[c - 1]
                        : Integer.MAX_VALUE / 2;

                tmp[c] = grid[r][c] + Math.min(up, left);
            }
            prev = tmp;
        }
        return prev[cols - 1];
    }
}
