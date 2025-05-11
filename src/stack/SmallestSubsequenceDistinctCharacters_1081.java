package stack;

/*
 * LeetCode Problem 1081: Smallest Subsequence of Distinct Characters
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, return the lexicographically smallest subsequence of s that contains all
 * the distinct characters of s exactly once.
 */

import java.util.Stack;

public class SmallestSubsequenceDistinctCharacters_1081 {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        boolean[] inStack = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (inStack[c - 'a']) continue;

            while (!stack.isEmpty() &&
                    c < stack.peek() &&
                    count[stack.peek() - 'a'] > 0) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();
    }
}
