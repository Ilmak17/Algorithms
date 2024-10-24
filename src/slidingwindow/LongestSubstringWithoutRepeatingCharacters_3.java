package slidingwindow;

/*
 * LeetCode Problem 3: Longest Substring Without Repeating Characters
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, find the length of the longest substringwithout repeating characters.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0;
        int length = 0;
        for (int r = 0; r < s.length(); r++) {
            while (!set.add(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            length = Math.max(length, r - l + 1);
        }

        return length;
    }
}
