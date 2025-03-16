package binarysearch;

/*
 * LeetCode Problem 540: Single Element in a Sorted Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a sorted array consisting of only integers where every element appears exactly twice,
 *  except for one element which appears exactly once.
 * Return the single element that appears only once.
 */

public class SingleElementInSortedArray_540 {

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid % 2 == 1) mid--;

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }
}
