package string;

/*
 * LeetCode Problem 3110: Score of a String
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given a string s. The score of a string is defined as the sum of the
 * absolute difference between the ASCII values of adjacent characters.
 * Return the score of s.
 */

public class ScoreOfString_3110 {
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return res;
    }
}
