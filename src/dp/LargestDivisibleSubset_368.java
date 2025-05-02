package dp;

/*
 * LeetCode Problem 368: Largest Divisible Subset
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a set of distinct positive integers nums, return the largest subset answer such that every pair
 * (answer[i], answer[j]) of elements in this subset satisfies:
 * answer[i] % answer[j] == 0, or answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset_368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        if (n == 0) return res;

        Arrays.sort(nums);

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1;
        int lastIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                lastIdx = i;
            }
        }

        while (lastIdx != -1) {
            res.add(nums[lastIdx]);
            lastIdx = parent[lastIdx];
        }

        return res;
    }
}
