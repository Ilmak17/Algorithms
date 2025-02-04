package arrayshashing;

/*
 * LeetCode Problem 1800: Maximum Ascending Subarray Sum
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.
 * A subarray is defined as a contiguous sequence of numbers in an array.
 * A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for
 *  all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
 */

public class MaximumAscendingSubarraySum_1800 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curSum += nums[i];
            } else {
                curSum = nums[i];
            }
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
