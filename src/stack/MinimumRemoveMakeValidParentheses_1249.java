package stack;

/*
 * LeetCode Problem 1249: Minimum Remove to Make Valid Parentheses
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a string s of '(' , ')' and lowercase English characters.
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 */


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MinimumRemoveMakeValidParentheses_1249 {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (val == '(') {
                stack.push(i);
            } else if (val == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                res.append(s.charAt(i));
            }

        }

        return res.toString();
    }
}
