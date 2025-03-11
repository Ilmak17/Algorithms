package arrayshashing;

/*
 * LeetCode Problem 2149: Rearrange Array Elements by Sign
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 * You should return the array of nums such that the the array follows the given conditions:
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 */

public class RearrangeArrayElementsSign_2149 {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int posIndex = 0;
        int negIndex = 1;

        for (int n : nums) {
            if (n >= 0) {
                res[posIndex] = n;
                posIndex += 2;
            } else {
                res[negIndex] = n;
                negIndex += 2;
            }
        }

        return res;
    }
}
