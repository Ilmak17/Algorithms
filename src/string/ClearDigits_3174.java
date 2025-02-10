package string;

/*
 * LeetCode Problem 3174: Clear Digits
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given two binary strings a and b, return their sum as a binary string.
 */

public class ClearDigits_3174 {
    public String clearDigits(String s) {
        StringBuilder stack = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!stack.isEmpty()) {
                    stack.deleteCharAt(stack.length() - 1);
                }
            } else {
                stack.append(c);
            }
        }
        return stack.toString();
    }
}
