package binarysearch;

/*
 * LeetCode Problem 4: Median of Two Sorted Arrays
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 */

public class MedianTwoSortedArrays_4 {

    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;

        if (n1 > n2)
            return findMedianSortedArrays(arr2, arr1);

        int n = n1 + n2;

        int left = (n1 + n2 + 1) / 2;

        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) >> 1;

            int mid2 = left - mid1;

            int l1 = (mid1 > 0) ? arr1[mid1 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? arr1[mid1] : Integer.MAX_VALUE;
            int l2 = (mid2 > 0) ? arr2[mid2 - 1] : Integer.MIN_VALUE;
            int r2 = (mid2 < n2) ? arr2[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1)
                    return Math.max(l1, l2);
                else
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return 0;
    }
}
