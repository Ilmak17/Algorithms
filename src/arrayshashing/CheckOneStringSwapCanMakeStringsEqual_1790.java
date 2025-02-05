package arrayshashing;

/*
 * LeetCode Problem 1790: Check if One String Swap Can Make Strings Equal
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given two strings s1 and s2 of equal length.
 * A string swap is an operation where you choose two indices in a string (not necessarily different) and swap the characters at these indices.
 * Return true if it is possible to make both strings equal
 * by performing at most one string swap on exactly one of the strings. Otherwise, return false.
 */

import java.util.ArrayList;
import java.util.List;

public class CheckOneStringSwapCanMakeStringsEqual_1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() != s2.length()) {
            return false;
        }

        List<Integer> diffIndices = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffIndices.add(i);
            }
        }

        if (diffIndices.size() != 2) return false;

        int i = diffIndices.get(0);
        int j = diffIndices.get(1);

        return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
    }
}
