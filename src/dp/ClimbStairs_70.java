package dp;

/*
 * LeetCode Problem 70: Climbing Stairs
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

import java.util.Arrays;

public class ClimbStairs_70 {

    // top down with memo[]
    public int climbStairsTopDown(int n) {
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);

        return climbStairsTopDown(n, memo);
    }

    private int climbStairsTopDown(int n, int[] cache) {
        if (n <= 1) {
            return 1;
        }
        if (cache[n] != - 1) {
            return cache[n];
        }
        cache[n] = climbStairsTopDown(n - 1, cache) + climbStairsTopDown(n - 2, cache);

        return cache[n];
    }


    // bottom up
    public int climbStairsBottomUp(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // bottom up optimized
    public int climbStairsBottomUpOptimized(int n) {
        if (n == 1) {
            return 1;
        }

        int res = 0;
        int i1 = 1;
        int i2 = 1;

        for (int i = 2; i <= n; i++) {
            res = i1 + i2;
            i2 = i1;
            i1 = res;
        }

        return res;
    }
}
