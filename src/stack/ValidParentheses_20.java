package stack;

/*
 * LeetCode Problem 20: Valid Parentheses
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 */


public class ValidParentheses_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char prevCh = stack.pop();

                if (prevCh == '(' && ch != ')') {
                    return false;
                }

                if (prevCh == '{' && ch != '}') {
                    return false;
                }

                if (prevCh == '[' && ch != ']') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
