package dp;

/*
 * LeetCode Problem 120: Triangle
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a triangle array, return the minimum path sum from top to bottom.
 * For each step, you may move to an adjacent number of the row below. More formally,
 *  if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
 */

import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        Integer[] prev = new Integer[n];

        for (int i = 0; i < n; i++) {
            prev[i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            Integer[] cur = new Integer[n];
            for (int j = 0; j <= i; j++) {
                cur[j] = Math.min(prev[j], prev[j + 1]) + triangle.get(i).get(j);
            }
            prev = cur;
        }

        return prev[0];
    }
}
