package dp;

/*
 * LeetCode Problem 152: Maximum Product Subarray
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */

public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1;
        int curMax = 1;

        for (int num : nums) {
            int tmp = curMax * num;

            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);

            res = Math.max(res, curMax);
        }

        return res;
    }
}
