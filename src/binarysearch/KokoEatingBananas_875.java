package binarysearch;

/*
 * LeetCode Problem 875: Koko Eating Bananas
 * Difficulty: Medium
 *
 * Problem Statement:
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
 *  The guards have gone and will come back in h hours.
 * Koko can decide her bananas-per-hour eating speed of k. Each hour,
 * she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 */

public class KokoEatingBananas_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int p : piles) {
            right = Math.max(right, p);
        }

        int res = 0;
        while (left <= right) {
            int k = left + (right - left) / 2;

            long totalTime = 0;
            for (int p : piles) {
                totalTime += (int) Math.ceil((double) p / k);
            }

            if (totalTime <= h) {
                res = k;
                right = k - 1;
            } else {
                left = k + 1;
            }
        }

        return res;
    }
}
