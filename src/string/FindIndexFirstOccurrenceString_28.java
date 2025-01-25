package string;

/*
 * LeetCode Problem 28: Find the Index of the First Occurrence in a String
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two strings needle and haystack,
 * return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */


public class FindIndexFirstOccurrenceString_28 {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (checkValues(haystack, needle, i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean checkValues(String s1, String s2, int i) {
        for (int j = 0; j < s2.length(); j++) {
            if (s1.charAt(i + j) != s2.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
