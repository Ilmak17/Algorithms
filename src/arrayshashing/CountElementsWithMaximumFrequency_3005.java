package arrayshashing;

/*
 * LeetCode Problem 3005: Count Elements With Maximum Frequency
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given an array nums consisting of positive integers.
 * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
 * The frequency of an element is the number of occurrences of that element in the array.
 */

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency_3005 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int maxCount = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : map.values()) {
            if (maxCount < val) {
                sum = val;
                maxCount = val;
            } else if (maxCount == val) {
                sum += val;
            }
        }

        return sum;
    }
}
