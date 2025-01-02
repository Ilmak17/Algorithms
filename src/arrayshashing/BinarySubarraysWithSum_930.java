package arrayshashing;

/*
 * LeetCode Problem 930: Binary Subarrays With Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 * A subarray is a contiguous part of the array.
 * * Return the array answer.
 */

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum_930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int counter = 0;

        for (int num : nums) {
            prefixSum += num;

            if (map.containsKey(prefixSum - goal)) {
                counter += map.get(prefixSum - goal);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return counter;
    }
}
