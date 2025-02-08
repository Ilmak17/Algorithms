package arrayshashing;

/*
 * LeetCode Problem 380: Insert Delete GetRandom O(1)
 * Difficulty: Medium
 *
 * Problem Statement:
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DesignNumberContainerSystem_2349 {
    private final Map<Integer, Integer> mapIndexes;
    private final Map<Integer, TreeSet<Integer>> mapNumbers;

    public DesignNumberContainerSystem_2349() {
        mapIndexes = new HashMap<>();
        mapNumbers = new HashMap<>();
    }

    public void change(int index, int number) {
        if (mapIndexes.containsKey(index)) {
            int numToRemoveIdx = mapIndexes.get(index);
            Set<Integer> set = mapNumbers.get(numToRemoveIdx);
            set.remove(index);
        }
        mapIndexes.put(index, number);

        mapNumbers.computeIfAbsent(number, k -> new TreeSet<>())
                .add(index);
    }

    public int find(int number) {
        return mapNumbers.containsKey(number) && !mapNumbers.get(number).isEmpty()
                ? mapNumbers.get(number).first()
                : -1;
    }
}
