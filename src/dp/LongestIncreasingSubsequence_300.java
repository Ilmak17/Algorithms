package dp;

/*
 * LeetCode Problem 300: Longest Increasing Subsequence
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 */

public class LongestIncreasingSubsequence_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = 1;
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        return maxLength;
    }
}
