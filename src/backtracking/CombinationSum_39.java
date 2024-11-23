package backtracking;

/*
 * LeetCode Problem 39: Combination Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of distinct integers candidates and a target integer target,
 *  return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations
 * that sum up to target is less than 150 combinations for the given input.
 */


import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] candidates, int idx, int target,
                           List<Integer> comb, List<List<Integer>> combs) {
        if (target == 0) {
            combs.add(new ArrayList<>(comb));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            comb.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], comb, combs);
            comb.remove(comb.size() - 1);
        }
    }
}
