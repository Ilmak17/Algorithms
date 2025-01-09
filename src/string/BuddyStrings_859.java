package string;

/*
 * LeetCode Problem 859: Buddy Strings
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given two strings s and goal, return true if you can swap two letters
 * in s so the result is equal to goal, otherwise, return false.
 * Swapping letters is defined as taking two indices i and j (0-indexed)
 * such that i != j and swapping the characters at s[i] and s[j].
 * For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyStrings_859 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            Set<Character> set = new HashSet<>();
            for (char ch : s.toCharArray()) {
                if (!set.add(ch)) {
                    return true;
                }
            }
            return false;
        }

        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        if (diff.size() != 2) {
            return false;
        }
        int i = diff.get(0);
        int j = diff.get(1);

        return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
    }
}
