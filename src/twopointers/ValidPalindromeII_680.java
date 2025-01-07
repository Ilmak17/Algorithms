package twopointers;

/*
 * LeetCode Problem 680: Valid Palindrome II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 */

public class ValidPalindromeII_680 {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return validPalin(s, start + 1, end) || validPalin(s, start, end - 1);
            }
        }

        return true;
    }

    private boolean validPalin(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}
