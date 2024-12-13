package dp;

/*
 * LeetCode Problem 198: House Robber
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are a professional robber planning to rob houses along a street.
 *  Each house has a certain amount of money stashed,
 *  the only constraint stopping you from robbing each of them is that
 *  adjacent houses have security systems connected and it will automatically contact the police
 *  if two adjacent houses were broken into on the same night.
 */

public class HouseRobber_198 {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[n];
    }

    public int robSpaceOptimized(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int i1 = 0;
        int i2 = nums[0];

        for (int i = 2; i <= nums.length; i++) {
            int tmp = Math.max(i1 + nums[i - 1], i2);
            i1 = i2;
            i2 = tmp;
        }

        return i2;
    }
}
