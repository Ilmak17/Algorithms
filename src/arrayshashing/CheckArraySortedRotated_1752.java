package arrayshashing;

/*
 * LeetCode Problem 1752. Check if Array Is Sorted and Rotated
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array nums, return true if the array was originally sorted in non-decreasing order,
 *  then rotated some number of positions (including zero). Otherwise, return false.
 * There may be duplicates in the original array.
 */

public class CheckArraySortedRotated_1752 {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) return false;
        }

        return true;
    }
}
