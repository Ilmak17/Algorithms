package stack;

/*
 * LeetCode Problem 227: Basic Calculator II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 *  All intermediate results will be in the range of [-231, 231 - 1].
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
 *  such as eval().
 */

public class BasicCalculatorII_277 {
    public int calculate(String s) {
        int result = 0;
        int currentNumber = 0;
        int lastNumber = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                lastNumber = switch (operator) {
                    case '+' -> {
                        result += lastNumber;
                        yield currentNumber;
                    }
                    case '-' -> {
                        result += lastNumber;
                        yield -currentNumber;
                    }
                    case '*' -> lastNumber * currentNumber;
                    case '/' -> lastNumber / currentNumber;
                    default -> lastNumber;
                };

                operator = c;
                currentNumber = 0;
            }
        }

        result += lastNumber;
        return result;
    }
}
