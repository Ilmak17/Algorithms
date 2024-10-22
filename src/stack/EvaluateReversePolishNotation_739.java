package stack;

/*
 * LeetCode Problem 150: Evaluate Reverse Polish Notation
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */


import java.util.Stack;

public class EvaluateReversePolishNotation_739 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stackDigits = new Stack<>();
        for (String s : tokens) {
            if (isInteger(s)) {
                stackDigits.add(Integer.parseInt(s));
            } else {
                int secondValue = stackDigits.pop();
                int firstValue = stackDigits.pop();
                int res = 0;
                switch (s) {
                    case "/":
                        res = firstValue / secondValue;
                        break;
                    case "*":
                        res = firstValue * secondValue;
                        break;
                    case "+":
                        res = firstValue + secondValue;
                        break;
                    case "-":
                        res = firstValue - secondValue;
                        break;
                }
                stackDigits.push(res);
            }
        }

        return stackDigits.pop();
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
