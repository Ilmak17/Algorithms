package twopointers;

/*
 * LeetCode Problem 1768: Merge Strings Alternately
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order,
 * starting with word1. If a string is longer than the other,
 *  append the additional letters onto the end of the merged string.
 * Return the merged string
 */

public class MergeStringsAlternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        int j = 0;

        while (i < word1.length() && j < word2.length()) {
            builder.append(word1.charAt(i++));
            builder.append(word2.charAt(j++));
        }

        while (i < word1.length())
            builder.append(word1.charAt(i++));
        while (j < word2.length())
            builder.append(word2.charAt(j++));

        return builder.toString();
    }
}
