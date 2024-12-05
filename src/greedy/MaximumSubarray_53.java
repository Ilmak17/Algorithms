package greedy;

/*
 * LeetCode Problem 53: Maximum Subarray
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 */

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        int curSum = 0;
        int maxSum = nums[0];

        for (int n : nums) {
            curSum = Math.max(curSum, 0);
            curSum += n;
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
