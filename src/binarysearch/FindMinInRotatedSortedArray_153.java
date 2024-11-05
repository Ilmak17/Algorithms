package binarysearch;

/*
 * LeetCode Problem 153: Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1
 * time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums of unique elements,
 * return the minimum element of this array.
 * You must write an algorithm that runs in O(log n) time.
 */

public class FindMinInRotatedSortedArray_153 {

    public int findMin(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return arr[r];
    }
}
