package arrayshashing;

/*
 * LeetCode Problem 3151. Special Array I
 * Difficulty: Medium
 *
 * Problem Statement:
 * An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
 * You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.
 */

public class SpecialArrayI_3151 {
    public boolean isArraySpecial(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        boolean isFirstOdd = nums[0] % 2 != 0;
        for (int i = 1; i < nums.length; i++) {
            boolean isOdd = nums[i] % 2 != 0;
            if ((i % 2 == 0 && isOdd != isFirstOdd) || (i % 2 != 0 && isOdd == isFirstOdd)) {
                return false;
            }
        }

        return true;
    }
}
