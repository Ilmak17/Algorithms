package binarysearch;

/*
 * LeetCode Problem 2300: Successful Pairs of Spells and Potions
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given two positive integer arrays spells and potions, of length n and m respectively,
 * where spells[i] represents the strength of the ith spell and potions[j] represents the strength of the jth potion.
 * You are also given an integer success. A spell and potion pair is considered successful
 *  if the product of their strengths is at least success.
 * Return an integer array pairs of length n where pairs[i] is the number of potions that will
 * form a successful pair with the ith spell.
 */

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m = potions.length;
        int[] res = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            int s = spells[i];
            if (s == 0) {
                res[i] = 0;
                continue;
            }

            long pMin = (success + s - 1L) / s;

            int idx = lowerBound(potions, pMin);
            res[i] = (idx < 0) ? 0 : (m - idx);
        }
        return res;
    }

    private int lowerBound(int[] a, long target) {
        int l = 0, r = a.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if ((long)a[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
