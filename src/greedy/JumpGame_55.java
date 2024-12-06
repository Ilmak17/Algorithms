package greedy;

/*
 * LeetCode Problem 55: Jump Game
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer array nums.
 *  You are initially positioned at the array's first index,
 *  and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 */

public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }

            maxReach = Math.max(maxReach, nums[i] + i);

            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump2(int[] nums) {
        int goal = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }
}
