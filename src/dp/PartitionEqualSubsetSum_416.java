package dp;

/*
 * LeetCode Problem 416: Partition Equal Subset Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, return true
 * if you can partition the array
 * into two subsets such that the sum of the elements
 * in both subsets is equal or false otherwise.
 */

public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int n : nums) {
            sum += n;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int capacity = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[2][capacity + 1];

        for (int c = 0; c <= capacity; c++) {
            dp[0][c] = c == nums[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (dp[(i - 1) % 2][j]) {
                    dp[i % 2][j] = true;
                } else if (j >= nums[i]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - nums[i]];
                }
            }
        }

        return dp[(n - 1) % 2][capacity];
    }
}
