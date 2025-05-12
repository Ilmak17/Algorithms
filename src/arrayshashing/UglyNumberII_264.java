package arrayshashing;

/*
 * LeetCode Problem 264: Ugly Number II
 * Difficulty: Medium
 *
 * Problem Statement:
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 * Given an integer n, return the nth ugly number.
 */

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            int next2 = ugly[i2] * 2;
            int next3 = ugly[i3] * 3;
            int next5 = ugly[i5] * 5;

            int nextUgly = Math.min(next2, Math.min(next3, next5));
            ugly[i] = nextUgly;

            if (nextUgly == next2)
                i2++;
            if (nextUgly == next3)
                i3++;
            if (nextUgly == next5)
                i5++;
        }

        return ugly[n - 1];
    }
}
