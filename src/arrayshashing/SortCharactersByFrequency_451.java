package arrayshashing;

/*
 * LeetCode Problem 451: Sort Characters By Frequency
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 *  The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        StringBuilder builder = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> val = maxHeap.poll();

            builder.append(String.valueOf(val.getKey())
                    .repeat(Math.max(0, val.getValue())));
        }

        return builder.toString();
    }
}
