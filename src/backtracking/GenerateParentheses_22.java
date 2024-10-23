package backtracking;

/*
 * LeetCode Problem 22: Generate Parentheses
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses_22 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        char[] chrs = new char[n * 2];
        generateParenthesis(n, 0, 0, 0, chrs, res);

        return res;
    }

    public void generateParenthesis(int n, int i, int left, int right, char[] chrs, List<String> res) {
        if (left == n && right == n) {
            res.add(new String(chrs));

            return;
        }

        if (left > right) {
            chrs[i] = ')';
            generateParenthesis(n, i + 1, left, right + 1, chrs, res);
        }

        if (n > left) {
            chrs[i] = '(';
            generateParenthesis(n, i + 1, left + 1, right, chrs, res);
        }
    }
}
