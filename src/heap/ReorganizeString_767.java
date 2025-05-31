package heap;

/*
 * LeetCode Problem 767: Reorganize String
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * Return any possible rearrangement of s or return "" if not possible.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString_767 {
    public String reorganizeString(String str) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        StringBuilder builder = new StringBuilder();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        maxHeap.addAll(map.entrySet());
        Map.Entry<Character, Integer> prev = null;

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            builder.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);

            if (prev != null && prev.getValue() > 0) {
                maxHeap.add(prev);
            }
            prev = cur;
        }

        return builder.length() == str.length() ? builder.toString() : "";
    }
}
