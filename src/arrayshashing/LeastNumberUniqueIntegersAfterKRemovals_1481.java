package arrayshashing;

/*
 * LeetCode Problem 1481: Least Number of Unique Integers after K Removals
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers arr and an integer k.
 * Find the least number of unique integers after removing exactly k elements.
 */


import java.util.HashMap;
import java.util.Map;

public class LeastNumberUniqueIntegersAfterKRemovals_1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> elementFrequency = new HashMap<>();
        for (int num : arr) {
            elementFrequency.put(num, elementFrequency.getOrDefault(num, 0) + 1);
        }

        int n = arr.length;
        int[] frequencyCount = new int[n + 1];
        for (int freq : elementFrequency.values()) {
            frequencyCount[freq]++;
        }

        int uniqueElements = elementFrequency.size();

        for (int i = 1; i <= n; i++) {
            int elementsToRemove = Math.min(k / i, frequencyCount[i]);
            k -= (i * elementsToRemove);
            uniqueElements -= elementsToRemove;

            if (k < i) {
                return uniqueElements;
            }
        }

        return 0;
    }
}
