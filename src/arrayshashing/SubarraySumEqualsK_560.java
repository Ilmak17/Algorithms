package arrayshashing;

/*
 * LeetCode Problem 560: Subarray Sum Equals K
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int counter = 0;
        int sum = 0;
        for (int el : nums) {
            sum += el;
            if (map.containsKey(sum - k)) {
                counter += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return counter;
    }
}
