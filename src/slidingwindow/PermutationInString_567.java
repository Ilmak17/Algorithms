package slidingwindow;

/*
 * LeetCode Problem 567: Permutation in String
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 */

import java.util.HashMap;
import java.util.Map;

public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int matches = 0;
        int left = 0;
        for (int right = 0; right < s2.length(); right++) {
            char rightCh = s2.charAt(right);
            if (map.containsKey(rightCh)) {
                map.put(rightCh, map.get(rightCh) - 1);
                if (map.get(rightCh) == 0) matches++;
            }

            if (right >= s1.length()) {
                char leftCh = s2.charAt(left++);
                if (map.containsKey(leftCh)) {
                    if (map.get(leftCh) == 0) matches--;
                    map.put(leftCh, map.get(leftCh) + 1);
                }
            }

            if (matches == map.size()) {
                return true;
            }
        }

        return false;
    }
}
