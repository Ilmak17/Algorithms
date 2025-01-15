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
        int res = 0;
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if ((long) mid * mid > x) {
                right = mid - 1;
            } else if ((long) mid * mid < x) {
                left = mid + 1;
                res = mid;
            } else {
                return mid;
            }
        }

        return res;
    }
}
