package binarysearch;

/*
 * LeetCode Problem 658: Find K Closest Elements
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a sorted integer array arr, two integers k and x,
 * return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */

import java.util.List;

public class FindKClosestElements_658 {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}
