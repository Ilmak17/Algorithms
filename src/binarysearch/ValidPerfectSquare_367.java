package binarysearch;

/*
 * LeetCode Problem 367: Valid Perfect Square
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 * A perfect square is an integer that is the square of an integer.
 * In other words, it is the product of some integer with itself.
 * You must not use any built-in library function, such as sqrt.
 *
 */

public class ValidPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == num) {
                return true;
            } else if (square > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
