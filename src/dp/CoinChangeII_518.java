package dp;

/*
 * LeetCode Problem 518. Coin Change II
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array coins representing coins of different denominations
 * and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */


class CoinChangeII_518 {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int[][] dp = new int[2][amount + 1];

        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int s = 1; s <= amount; s++) {
                if (i > 0) {
                    dp[i % 2][s] = dp[(i - 1) % 2][s];
                }
                if (s >= coins[i]) {
                    dp[i % 2][s] += dp[i % 2][s - coins[i]];
                }
            }
        }
        return dp[(n - 1) % 2][amount];
    }
}