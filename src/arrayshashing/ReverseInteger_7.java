package arrayshashing;

/*
 * LeetCode Problem 7: Reverse Integer
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a signed 32-bit integer x, return x with its digits reversed.
 *  If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */

public class ReverseInteger_7 {
    public int reverse(int x) {
        long reverseValue = 0;

        while (x != 0) {
            int remainder = x % 10;
            x = x / 10;
            reverseValue = reverseValue * 10 + remainder;
        }

        if (reverseValue > Integer.MAX_VALUE || reverseValue < Integer.MIN_VALUE) {
            return 0;
        }

        return (int) reverseValue;
    }
}
