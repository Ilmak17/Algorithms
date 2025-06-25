package dp;

/*
 * LeetCode Problem 63: Unique Paths II
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an m x n integer array grid. There is a robot initially located at the top-left corner
 * (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 * The robot can only move either down or right at any point in time.
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot
 * include any square that is an obstacle.
 * Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 * The testcases are generated so that the answer will be less than or equal to 2 * 109.
 */


public class UniquePathsII_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[] prev = new int[cols];

        for (int r = 0; r < rows; r++) {
            int[] temp = new int[cols];
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1)
                    continue;
                if (r == 0 && c == 0) {
                    temp[c] = 1;
                    continue;
                }

                int up = 0, left = 0;
                if (r > 0)
                    up = prev[c];
                if (c > 0)
                    left = temp[c - 1];
                temp[c] = up + left;
            }
            prev = temp;
        }

        return prev[cols - 1];
    }
}
