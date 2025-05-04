package dp;

/*
 * LeetCode Problem 10: Regular Expression Matching
 * Difficulty: Hard
 *
 * Problem Statement:
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */

public class RegularExpressionMatching_10 {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];

        return isMatchHelper(s, p, s.length() - 1, p.length() - 1, dp);
    }

    private boolean isMatchHelper(String s, String p, int i1, int i2, Boolean[][] dp) {
        if (i1 < 0 && i2 < 0) return true;
        if (i2 < 0) return false;

        if (i1 < 0) {
            if (p.charAt(i2) == '*') {
                return i2 >= 1 && isMatchHelper(s, p, i1, i2 - 2, dp);
            }
            return false;
        }

        if (dp[i1][i2] != null) return dp[i1][i2];

        char sc = s.charAt(i1);
        char pc = p.charAt(i2);

        if (pc == '*') {
            char prev = p.charAt(i2 - 1);
            boolean skip = isMatchHelper(s, p, i1, i2 - 2, dp);
            boolean consume = (prev == sc || prev == '.') && isMatchHelper(s, p, i1 - 1, i2, dp);
            return dp[i1][i2] = skip || consume;
        }

        if (pc == '.' || pc == sc) {
            return dp[i1][i2] = isMatchHelper(s, p, i1 - 1, i2 - 1, dp);
        }

        return dp[i1][i2] = false;
    }
}
