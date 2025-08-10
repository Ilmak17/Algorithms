package binarysearch;

/*
 * LeetCode Problem 69: Sqrt(x)
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 */

public class SqrtX_69 {
    public int mySqrt(int x) {
        int low = 1;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long square = (long) mid * mid;
            if (square == x) {
                return mid;
            } else if (square > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }
}
