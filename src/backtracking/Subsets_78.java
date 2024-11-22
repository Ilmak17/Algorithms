package backtracking;

/*
 * LeetCode Problem 78: Subsets
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */


import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> set, List<List<Integer>> subsets) {
        if (idx >= nums.length) {
            subsets.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[idx]);
        backtrack(nums, idx + 1, set, subsets);
        set.remove(set.size() - 1);
        backtrack(nums, idx + 1, set, subsets);
    }
}
