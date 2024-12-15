package dp;

/*
 * LeetCode Problem 5: Longest Palindromic Substring
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, return the longest palindromic substring in s.
 */

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        return longestPalindrome(s, 0, s.length() - 1, new String[s.length()][s.length()]);
    }

    private String longestPalindrome(String s, int start, int end, String[][] memo) {
        if (start > end) {
            return "";
        }

        if (memo[start][end] != null) {
            return memo[start][end];
        }

        if (start == end) {
            return memo[start][end] = String.valueOf(s.charAt(start));
        }

        if (s.charAt(start) == s.charAt(end)) {
            String middle = longestPalindrome(s, start + 1, end - 1, memo);
            if (middle.length() == (end - start - 1)) {
                return memo[start][end] = s.substring(start, end + 1);
            }
        }

        String excludeStart = longestPalindrome(s, start + 1, end, memo);
        String excludeEnd = longestPalindrome(s, start, end - 1, memo);

        return memo[start][end] = (excludeStart.length() > excludeEnd.length()) ? excludeStart : excludeEnd;
    }
}
