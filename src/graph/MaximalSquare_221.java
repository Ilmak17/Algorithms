package graph;

/*
 * LeetCode Problem 221: Maximal Square
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */

import java.util.Arrays;

public class MaximalSquare_221 {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSide = 0;
        int[][] dp = new int[rows][cols];

        for (int[] el : dp) Arrays.fill(el, -1);

        // M * N
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                maxSide = Math.max(maxSide, helper(matrix, r, c, dp));
            }
        }

        return maxSide * maxSide;
    }

    private int helper(char[][] matrix, int r, int c, int[][] dp) {
        if (r < 0 || c < 0) return 0;
        if (matrix[r][c] == '0') return 0;
        if (dp[r][c] != -1) return dp[r][c];

        int up = helper(matrix, r - 1, c, dp);
        int left = helper(matrix, r, c - 1, dp);
        int diag = helper(matrix, r - 1, c - 1, dp);

        return dp[r][c] = 1 + Math.min(up, Math.min(left, diag));
    }
}
