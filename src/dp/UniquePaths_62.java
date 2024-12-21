package dp;

/*
 * LeetCode Problem 62: Unique Paths
 * Difficulty: Medium
 *
 * Problem Statement:
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
 * The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
 *  The robot can only move either down or right at any point in time.
 * Given the two integers m and n, return the number of possible unique paths that
 * the robot can take to reach the bottom-right corner.
 * The test cases are generated so that the answer will be less than or equal to 2 * 109
 */

public class UniquePaths_62 {
    private Integer[][] dp;
    private int endRow;
    private int endCol;

    public int uniquePaths(int m, int n) {
        dp = new Integer[m][n];
        endRow = m - 1;
        endCol = n - 1;

        return uniquePathsRecursive(0, 0);
    }

    private int uniquePathsRecursive(int row, int col) {
        if (row == endRow && col == endCol) {
            return 1;
        }

        if (row > endRow || col > endCol) {
            return 0;
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int down = uniquePathsRecursive(row + 1, col);
        int right = uniquePathsRecursive(row, col + 1);

        dp[row][col] = down + right;

        return dp[row][col];
    }
}
