package backtracking;

/*
 * LeetCode Problem 17: Letter Combinations of a Phone Number
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 *  Note that 1 does not map to any letters.
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber_17 {
    private final List<String> res = new ArrayList<>();
    private static final String[] DIGITS = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return res;
        backtrack(0, new StringBuilder(), digits);
        return res;
    }

    private void backtrack(int index, StringBuilder curStr, String digits) {
        if (index == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        String chars = DIGITS[digits.charAt(index) - '0'];
        for (char c : chars.toCharArray()) {
            curStr.append(c);
            backtrack(index + 1, curStr, digits);
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
