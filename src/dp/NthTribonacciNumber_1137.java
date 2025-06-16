package dp;

/*
 * LeetCode Problem 1137: N-th Tribonacci Number
 * Difficulty: Easy
 *
 * Problem Statement:
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 */

public class NthTribonacciNumber_1137 {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int i1 = 0;
        int i2 = 1;
        int i3 = 1;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = i1 + i2 + i3;
            i1 = i2;
            i2 = i3;
            i3 = res;
        }

        return res;
    }
}
