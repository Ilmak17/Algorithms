package binarysearch;

/*
 * LeetCode Problem 1482: Minimum Number of Days to Make m Bouquets
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array bloomDay, an integer m and an integer k.
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden.
 * If it is impossible to make m bouquets return -1.
 */

public class MinimumNumberDaysMakemBouquets_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) return -1;

        int minEl = Integer.MAX_VALUE;
        int maxEl = Integer.MIN_VALUE;
        for (int n : bloomDay) {
            minEl = Math.min(minEl, n);
            maxEl = Math.max(maxEl, n);
        }

        int low = minEl;
        int high = maxEl;

        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMakeBqts(bloomDay, mid, k, m)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;
    }

    private boolean canMakeBqts(int[] nums, int days, int k, int m) {
        int boquets = 0;
        int roses = 0;

        for (int n : nums) {
            if (n <= days) {
                roses++;
                continue;
            }
            boquets += roses / k;
            roses = 0;
        }

        boquets += roses / k;

        return boquets >= m;
    }
}
