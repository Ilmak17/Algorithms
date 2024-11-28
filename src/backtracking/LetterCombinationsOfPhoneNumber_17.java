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
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = DIGITS[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}
