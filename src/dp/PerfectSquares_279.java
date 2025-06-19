package dp;

/*
 * LeetCode Problem 279: Perfect Squares
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */

import java.util.Arrays;

public class PerfectSquares_279 {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n == 0) return 0;
        if (memo[n] != 0) return memo[n];

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            min = Math.min(min, helper(n - square, memo) + 1);
        }

        memo[n] = min;
        return min;
    }

    public int numSquaresBottomUp(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                dp[i] = Math.min(dp[i], dp[i - square] + 1);
            }
        }

        return dp[n];
    }
}
