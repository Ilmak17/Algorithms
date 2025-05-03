package dp;

/*
 * LeetCode Problem 115: Distinct Subsequences
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 */

public class DistinctSubsequences_115 {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] cur = new int[m + 1];
            cur[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    cur[j] = (dp[j - 1] + dp[j]) % Integer.MAX_VALUE;
                } else {
                    cur[j] = dp[j];
                }
            }
            dp = cur;
        }

        return dp[m];
    }
}
