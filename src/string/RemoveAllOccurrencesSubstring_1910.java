package string;

/*
 * LeetCode Problem 1910: Remove All Occurrences of a Substring
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
 * Find the leftmost occurrence of the substring part and remove it from s.
 * Return s after removing all occurrences of part.
 * A substring is a contiguous sequence of characters in a string.
 */

public class RemoveAllOccurrencesSubstring_1910 {
    public String removeOccurrences(String s, String part) {
        StringBuilder stack = new StringBuilder();
        int partLength = part.length();

        for (char c : s.toCharArray()) {
            stack.append(c);

            if (stack.length() >= partLength && stack.substring(stack.length() - partLength).equals(part)) {
                stack.setLength(stack.length() - partLength);
            }
        }

        return stack.toString();
    }
}
