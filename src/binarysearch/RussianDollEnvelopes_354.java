package binarysearch;

/*
 * LeetCode Problem 354: Russian Doll Envelopes
 * Difficulty: Hard
 *
 * Problem Statement:
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents
 *  the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of one
 * envelope are greater than the other envelope's width and height.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 */

import java.util.Arrays;

public class RussianDollEnvelopes_354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(b[1], a[1]);
        });

        int n = envelopes.length;
        int[] tails = new int[n];
        int size = 0;

        for (int[] env : envelopes) {
            int h = env[1];

            int i = Arrays.binarySearch(tails, 0, size, h);
            if (i < 0) i = -i - 1;

            tails[i] = h;
            if (i == size) size++;
        }

        return size;
    }
}
