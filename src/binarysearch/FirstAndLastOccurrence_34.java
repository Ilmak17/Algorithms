package binarysearch;

/*
 * LeetCode Problem 34: First and last occurrence
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of
 * a given target value. If the target is not found in the array, return [-1, -1].
 */

public class FirstAndLastOccurrence_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        if (nums.length == 0) {
            return res;
        }

        int start = binarySearch(nums, target - 0.5);
        int end = binarySearch(nums, target + 0.5);

        if (start == end) {
            return res;
        }
        res[0] = start;
        res[1] = end - 1;

        return res;
    }

    private int binarySearch(int[] nums, double val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
