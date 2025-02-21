package arrayshashing;

/*
 * LeetCode Problem 1347: Minimum Number of Steps to Make Two Strings Anagram
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given two strings of the same length s and t. In one step you can choose any character
 * of t and replace it with another character.
 * Return the minimum number of steps to make t an anagram of s.
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberStepsMakeTwoStringsAnagram_1347 {
    public int minSteps(String s, String t) {
        Map<Character, Integer> frequencyDifference = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charT = t.charAt(i);
            char charS = s.charAt(i);

            frequencyDifference.put(charT, frequencyDifference.getOrDefault(charT, 0) + 1);
            frequencyDifference.put(charS, frequencyDifference.getOrDefault(charS, 0) - 1);
        }

        int steps = 0;
        for (int count : frequencyDifference.values()) {
            if (count > 0) {
                steps += count;
            }
        }

        return steps;
    }
}
