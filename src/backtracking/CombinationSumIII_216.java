package backtracking;

/*
 * LeetCode Problem 216: Combination Sum III
 * Difficulty: Medium
 *
 * Problem Statement:
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations.
 * The list must not contain the same combination twice,
 * and the combinations may be returned in any order.
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int start, int sum, int k, List<Integer> cur, List<List<Integer>> res) {
        if (sum == 0 && cur.size() == k) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (sum < 0 || cur.size() >= k)
            return;

        for (int i = start; i <= 9; i++) {
            cur.add(i);
            backtrack(i + 1, sum - i, k, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
