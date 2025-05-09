package bitmanipulation;

/*
 * LeetCode Problem 136: Single Number
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int n : nums) ans ^= n;

        return ans;
    }
}
