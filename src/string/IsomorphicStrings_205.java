package string;

/*
 * LeetCode Problem 205: Isomorphic Strings
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters. No two characters may map to the same character,
 *  but a character may map to itself.
 */

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if (mapST.containsKey(chS)) {
                if (mapST.get(chS) != chT) {
                    return false;
                }
            } else {
                mapST.put(chS, chT);
            }

            if (mapTS.containsKey(chT)) {
                if (mapTS.get(chT) != chS) {
                    return false;
                }
            } else {
                mapTS.put(chT, chS);
            }
        }

        return true;
    }
}
