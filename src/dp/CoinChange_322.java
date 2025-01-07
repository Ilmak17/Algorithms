package dp;

/*
 * LeetCode Problem 322: Coin Change
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array coins representing coins of different
 *  denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount.
 *  If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */

public class CoinChange_322 {
    public int coinChange(int[] denominations, int total) {
        if (total == 0) {
            return 0;
        }

        int n = denominations.length;
        int[][] dp = new int[2][total + 1];

        for (int t = 1; t <= total; t++) {
            dp[0][t] = Integer.MAX_VALUE;
            dp[1][t] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < n; i++) {
            for (int t = 1; t <= total; t++) {
                if (i > 0) {
                    dp[i % 2][t] = dp[(i - 1) % 2][t];
                }
                if (t >= denominations[i] && dp[i % 2][t - denominations[i]] != Integer.MAX_VALUE) {
                    dp[i % 2][t] = Math.min(dp[i % 2][t], dp[i % 2][t - denominations[i]] + 1);
                }
            }
        }

        return (dp[(n - 1) % 2][total] == Integer.MAX_VALUE ? -1 : dp[(n - 1) % 2][total]);
    }
}
