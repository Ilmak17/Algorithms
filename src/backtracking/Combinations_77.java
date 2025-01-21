package backtracking;

/*
 * LeetCode Problem 77: Combinations
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * You may return the answer in any order.
 */

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> comb, List<List<Integer>> combs) {
        if (comb.size() == k) {
            combs.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(n, k, i + 1, comb, combs);
            comb.remove(comb.size() - 1);
        }
    }
}
