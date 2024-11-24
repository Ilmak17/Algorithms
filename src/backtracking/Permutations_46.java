package backtracking;

/*
 * LeetCode Problem 46: Permutations
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array nums of distinct integers, return all the possible
 * permutations. You can return the answer in any order.
 */


import java.util.ArrayList;
import java.util.List;

public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), permutations);

        return permutations;
    }

    private void backtrack(int[] nums, int idx, List<Integer> permutation, List<List<Integer>> permutations) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<>(permutation));
            return;
        }

        int n = permutation.size();
        for (int i = 0; i <= n; i++) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            newPermutation.add(i, nums[idx]);
            backtrack(nums, idx + 1, newPermutation, permutations);
        }
    }
}
