package bitmanipulation;

/*
 * LeetCode Problem 137: Single Number
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums where every element appears three times except for one, which appears exactly once.
 * Find the single element and return it.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */

public class SingleNumberII_137 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int n : nums) {
            ones = (ones ^ n) & ~twos;
            twos = (twos ^ n) & ~ones;
        }

        return ones;
    }
}
