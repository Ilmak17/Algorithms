package binarysearch;

/*
 * LeetCode Problem 410: Split Array Largest Sum
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays
 * such that the largest sum of any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 */

public class SplitArrayLargestSum_410 {

    public int splitArray(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
            sum += num;
        }

        int low = maxVal;
        int high = sum;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int requiredSplits = countSubarrays(nums, mid);

            if (requiredSplits > k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countSubarrays(int[] nums, int maxSum) {
        int subarrays = 1;
        int curSum = 0;

        for (int num : nums) {
            if (curSum + num > maxSum) {
                subarrays++;
                curSum = num;
            } else {
                curSum += num;
            }
        }

        return subarrays;
    }
}
