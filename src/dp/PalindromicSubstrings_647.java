package dp;

/*
 * LeetCode Problem 647: Palindromic Substrings
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 */

public class PalindromicSubstrings_647 {
    public int countSubstrings(String s) {
        int n = s.length();

        int counter = 0;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            counter++;
        }

        for (int start = s.length() - 1; start >= 0; start--) {
            for (int end = start + 1; end < s.length(); end++) {
                if (s.charAt(start) == s.charAt(end)) {
                    if (end - start == 1 || dp[start + 1][end - 1]) {
                        dp[start][end] = true;
                        counter++;
                    }
                }
            }
        }

        return counter;
    }
}
