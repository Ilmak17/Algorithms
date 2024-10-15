package arraysHashing;

/*
 * LeetCode Problem 347: Top K Frequent Elements
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums and an integer k, return the k most frequent elements.
 *  You may return the answer in any order.
 */


import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap
                = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) res[i] = maxHeap.poll().getKey();

        return res;
    }
}
