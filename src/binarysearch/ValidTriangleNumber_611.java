package binarysearch;

/*
 * LeetCode Problem 611: Valid Triangle Number
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, return the number of triplets chosen from the array that can make triangles
 * if we take them as side lengths of a triangle.
 */

import java.util.Arrays;

public class ValidTriangleNumber_611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
