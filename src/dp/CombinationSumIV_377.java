package dp;

/*
 * LeetCode Problem 377: Combination Sum IV
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of distinct integers nums and a target integer target,
 *  return the number of possible combinations that add up to target.
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV_377 {
    private Map<Integer, Integer> memo;

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        memo = new HashMap<>();
        memo.put(0, 1);
        return dfs(nums, target);
    }

    private int dfs(int[] nums, int total) {
        if (memo.containsKey(total)) {
            return memo.get(total);
        }

        int res = 0;
        for (int num : nums) {
            if (total < num) {
                break;
            }
            res += dfs(nums, total - num);
        }
        memo.put(total, res);
        return res;
    }
}
