package backtracking;

/*
 * LeetCode Problem 40: Combination Sum II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> response = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), response);

        return response;
    }

    private void backtrack(int[] candidates, int target, int idx, List<Integer> comb, List<List<Integer>> combs) {
        if (target == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, comb, combs);
            comb.remove(comb.size() - 1);
        }
    }
}
