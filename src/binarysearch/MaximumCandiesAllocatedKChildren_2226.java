package binarysearch;

/*
 * LeetCode Problem 2226: Maximum Candies Allocated to K Children
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a 0-indexed integer array candies. Each element in the array denotes
 * a pile of candies of size candies[i]. You can divide each pile into any number of sub piles,
 * but you cannot merge two piles together.
 * You are also given an integer k. You should allocate piles of candies to k children such that each
 * child gets the same number of candies. Each child can be allocated candies from only one pile
 *  of candies and some piles of candies may go unused.
 * Return the maximum number of candies each child can get.
 */

public class MaximumCandiesAllocatedKChildren_2226 {
    public int maximumCandies(int[] candies, long k) {

        int maxVal = Integer.MIN_VALUE;

        for (int c : candies) {
            maxVal = Math.max(c, maxVal);
        }

        int low = 1;
        int high = maxVal;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canTake(candies, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high;
    }

    private boolean canTake(int[] candies, int num, long k) {
        long count = 0;

        for (int c : candies) {
            count += c / num;
        }

        return count >= k;
    }
}
