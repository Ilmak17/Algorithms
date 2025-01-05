package arrayshashing;

/*
 * LeetCode Problem 189: Rotate Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }

    private void rotate(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
