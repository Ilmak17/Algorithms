package arrayshashing;

/*
 * LeetCode Problem 2364. Count Number of Bad Pairs
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given a 0-indexed integer array nums. A pair of indices (i, j)
 * is a bad pair if i < j and j - i != nums[j] - nums[i].
 * Return the total number of bad pairs in nums.
 */

import java.util.HashMap;
import java.util.Map;

public class CountNumberBadPairs_2364 {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        long goodPairs = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            goodPairs += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        long totalPairs = (long) n * (n - 1) / 2;

        return totalPairs - goodPairs;
    }
}
