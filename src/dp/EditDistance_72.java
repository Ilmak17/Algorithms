package dp;

/*
 * LeetCode Problem 72: Edit Distance
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.
 * You have the following three operations permitted on a word:
 * Insert a character
 * Delete a character
 * Replace a character
 */

public class EditDistance_72 {
    public int minDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i1 = 0; i1 <= s1.length(); i1++)
            dp[i1][0] = i1;

        for (int i2 = 0; i2 <= s2.length(); i2++)
            dp[0][i2] = i2;

        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1))
                    dp[i1][i2] = dp[i1 - 1][i2 - 1];
                else
                    dp[i1][i2] = 1 + Math.min(dp[i1 - 1][i2],
                            Math.min(dp[i1][i2 - 1],
                                    dp[i1 - 1][i2 - 1]));
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
