package backtracking;

/*
 * LeetCode Problem 90: Subsets II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset, List<List<Integer>> subsets) {
        if (idx >= nums.length) {
            subsets.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        backtrack(nums, idx + 1, subset, subsets);
        subset.remove(subset.size() - 1);
        while (idx + 1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        backtrack(nums, idx + 1, subset, subsets);
    }
}
