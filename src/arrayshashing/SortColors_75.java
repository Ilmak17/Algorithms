package arrayshashing;

/*
 * LeetCode Problem 75: Sort Colors
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array nums with n objects colored red, white, or blue,
 *  sort them in-place so that objects of the same color are adjacent,
 *  with the colors in the order red, white, and blue.
 */

public class SortColors_75 {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
