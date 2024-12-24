package dp;

/*
 * LeetCode Problem 494: Target Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-'
 *  before each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate
 * them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */

public class TargetSum_494 {
    private int[][] dp;
    private int totalSum;

    public int findTargetSumWays(int[] nums, int target) {
        totalSum = 0;
        for (int num : nums) totalSum += num;
        dp = new int[nums.length][2 * totalSum + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 2 * totalSum + 1; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        return backtrack(0, 0, nums, target);
    }

    private int backtrack(int i, int total, int[] nums, int target) {
        if (i == nums.length) {
            return total == target ? 1 : 0;
        }
        if (dp[i][total + totalSum] != Integer.MIN_VALUE) {
            return dp[i][total + totalSum];
        }
        dp[i][total + totalSum] = backtrack(i + 1, total + nums[i], nums, target) +
                backtrack(i + 1, total - nums[i], nums, target);

        return dp[i][total + totalSum];
    }
}
