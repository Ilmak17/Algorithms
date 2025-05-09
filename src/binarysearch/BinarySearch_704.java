package binarysearch;

/*
 * LeetCode Problem 704: Binary Search
 * Difficulty: Easy
 *
 * Problem Statement:
 * Binary Search
 */

public class BinarySearch_704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}
