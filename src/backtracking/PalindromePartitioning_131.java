package backtracking;

/*
 * LeetCode Problem 131: Palindrome Partitioning
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, res, new ArrayList<>());
        return res;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private void backtrack(String s, int idx, List<List<String>> res, List<String> pali) {
        if (s.length() == idx) {
            res.add(new ArrayList<>(pali));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                pali.add(s.substring(idx, i + 1));
                backtrack(s, i + 1, res, pali);
                pali.remove(pali.size() - 1);
            }
        }
    }
}
