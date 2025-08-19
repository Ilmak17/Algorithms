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

    public int lengthOfLISBinarySearch(int[] nums) {
        if (nums.length == 0) return 0;

        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = lowerBound(tails, 0, size, x);
            tails[i] = x;
            if (i == size) size++;
        }
        return size;
    }

    private int lowerBound(int[] a, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] >= target) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}
