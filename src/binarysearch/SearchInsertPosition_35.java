package binarysearch;

/*
 * LeetCode Problem 35: Search Insert Position
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 *  If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */

public class SearchInsertPosition_35 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return start;
    }
}
