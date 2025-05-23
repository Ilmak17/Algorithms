package arrayshashing;

/*
 * LeetCode Problem 274: H-Index
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers citations where citations[i] is
 * the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia:
 * The h-index is defined as the maximum value of h such that the given researcher
 * has published at least h papers that have each been cited at least h times.
 */


import java.util.Arrays;

public class HIndex_274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                return h;
            }
        }

        return 0;
    }
}
