package graph;

/*
 * LeetCode Problem 953: Verifying an Alien Dictionary
 * Difficulty: Easy
 *
 * Problem Statement:
 * In an alien language, surprisingly, they also use English lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographically in this alien language.
 */

import java.util.HashMap;
import java.util.Map;

public class VerifyingAlienDictionary_953 {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int len = Math.min(word1.length(), word2.length());

            boolean isDifferent = false;
            for (int j = 0; j < len; j++) {
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if (map.get(ch1) < map.get(ch2)) {
                    isDifferent = true;
                    break;
                } else if (map.get(ch1) > map.get(ch2)) {
                    return false;
                }
            }

            if (!isDifferent && word1.length() > word2.length()) {
                return false;
            }
        }

        return true;
    }
}
