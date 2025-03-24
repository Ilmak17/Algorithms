package backtracking;

/*
 * LeetCode Problem 50: Pow(x, n)
 * Difficulty: Medium
 *
 * Problem Statement:
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 */

public class PowXN_50 {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            return 1.0 / power(x, -N);
        }

        return power(x, n);
    }

    private double power(double x, long n) {
        if (n == 0) return 1;
        if (n % 2 == 1) return x * power(x, n - 1);

        return power(x * x, n / 2);
    }
}
