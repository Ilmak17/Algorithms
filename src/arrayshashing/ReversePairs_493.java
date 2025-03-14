package arrayshashing;

/*
 * LeetCode Problem 493: Reverse Pairs
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given an integer array nums, return the number of reverse pairs in the array.
 * A reverse pair is a pair (i, j) where:
 * 0 <= i < j < nums.length and
 * nums[i] > 2 * nums[j].
 */

import java.util.ArrayList;
import java.util.List;

public class ReversePairs_493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = low + (high - low) / 2;
        int pairs = 0;

        pairs += mergeSort(nums, low, mid);
        pairs += mergeSort(nums, mid + 1, high);
        pairs += countPairs(nums, low, mid, high);

        merge(nums, low, mid, high);

        return pairs;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        List<Integer> tmp = new ArrayList<>();

        int left = low, right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                tmp.add(nums[left++]);
            } else {
                tmp.add(nums[right++]);
            }
        }

        while (left <= mid) {
            tmp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            tmp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = tmp.get(i - low);
        }
    }

    private int countPairs(int[] nums, int low, int mid, int high) {
        int pairs = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) nums[i] > 2L * nums[right]) right++;
            pairs += (right - (mid + 1));
        }

        return pairs;
    }
}
