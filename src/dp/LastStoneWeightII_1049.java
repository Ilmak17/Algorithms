package dp;

/*
 * LeetCode Problem 1049: Last Stone Weight II
 * Difficulty: Medium
 *
 * Problem Statement:
 *
 */

public class LastStoneWeightII_1049 {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int stone : stones) {
            total += stone;
        }
        int target = total / 2;

        Integer[][] memo = new Integer[stones.length][target + 1];
        int best = dfs(stones, 0, target, memo);

        return total - 2 * best; // total - 2 * s1 = |s1 - s2|
    }

    private int dfs(int[] stones, int i, int remaining, Integer[][] memo) {
        if (i == stones.length) return 0;
        if (memo[i][remaining] != null) return memo[i][remaining];

        int without = dfs(stones, i + 1, remaining, memo);

        int with = 0;
        if (stones[i] <= remaining) {
            with = stones[i] + dfs(stones, i + 1, remaining - stones[i], memo);
        }

        memo[i][remaining] = Math.max(with, without);
        return memo[i][remaining];
    }
}
