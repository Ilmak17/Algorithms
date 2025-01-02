package arrayshashing;

/*
 * LeetCode Problem 974: Subarray Sums Divisible by K
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums and an integer k,
 * return the number of non-empty subarrays that have a sum divisible by k.
 * A subarray is a contiguous part of an array.
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK_974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefixSum = 0;
        int counter = 0;

        for (int el : nums) {
            prefixSum += el;

            int remainder = prefixSum % k;
            if (remainder < 0) remainder += k;

            counter += map.getOrDefault(remainder, 0);
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return counter;
    }
}
