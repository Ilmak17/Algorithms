package arrayshashing;

/*
 * LeetCode Problem 315: Count of Smaller Numbers After Self
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given an integer array nums, return an integer array counts where counts[i]
 * is the number of smaller elements to the right of nums[i].
 */


import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf_315 {

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        mergeSort(pairs, 0, n - 1, counts);

        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }

        return result;
    }

    private void mergeSort(Pair[] pairs, int left, int right, int[] counts) {
        if (left >= right) return;

        // to prevent overflow
        int mid = left + (right - left) / 2;

        mergeSort(pairs, left, mid, counts);
        mergeSort(pairs, mid + 1, right, counts);

        merge(pairs, left, mid, right, counts);
    }

    private void merge(Pair[] pairs, int left, int mid, int right, int[] counts) {
        List<Pair> merged = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        int rightCounter = 0;

        while (i <= mid && j <= right) {
            if (pairs[i].val <= pairs[j].val) {
                counts[pairs[i].idx] += rightCounter;
                merged.add(pairs[i++]);
            } else {
                rightCounter++;
                merged.add(pairs[j++]);
            }
        }

        while (i <= mid) {
            counts[pairs[i].idx] += rightCounter;
            merged.add(pairs[i++]);
        }

        while (j <= right) {
            merged.add(pairs[j++]);
        }

        for (int k = 0; k < merged.size(); k++) {
            pairs[left + k] = merged.get(k);
        }
    }

    private static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
