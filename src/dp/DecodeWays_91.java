package dp;

/*
 * LeetCode Problem 91: Decode Ways
 * Difficulty: Medium
 *
 * Problem Statement:
 * You have intercepted a secret message encoded as a string of numbers.
 */

public class DecodeWays_91 {
    private Integer[] dp;

    public int numDecodingsTopDown(String s) {
        dp = new Integer[s.length()];
        return numDecodingsTopDown(s, 0);
    }

    private int numDecodingsTopDown(String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        int count = numDecodingsTopDown(s, idx + 1);

        if (idx + 1 < s.length()) {
            int twoDigit = Integer.parseInt(s.substring(idx, idx + 2));
            if (twoDigit <= 26) {
                count += numDecodingsTopDown(s, idx + 2);
            }
        }
        dp[idx] = count;

        return dp[idx];
    }
}
