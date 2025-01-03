package arrayshashing;

/*
 * LeetCode Problem 1685: Sum of Absolute Differences in a Sorted Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array nums sorted in non-decreasing order.
 * Build and return an integer array result with the same length
 *  as nums such that result[i] is equal to the summation of absolute
 *  differences between nums[i] and all the other elements in the array.
 * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
 */

public class SumAbsoluteDifferencesSortedArray_1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[n] - prefixSum[i + 1];
            result[i] = i * nums[i] - leftSum + rightSum - (n - i - 1) * nums[i];
        }

        return result;
    }
}
