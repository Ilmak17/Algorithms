package greedy;

/*
 * LeetCode Problem 678: Valid Parenthesis String
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
 * The following rules define a valid string:
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 */

public class ValidParenthesisString_678 {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                if (low > 0)
                    low--;
                high--;
            } else {
                if (low > 0)
                    low--;
                high++;
            }
            if (high < 0)
                return false;
        }
        return low == 0;
    }
}
