package arrayshashing;

/*
 * LeetCode Problem 2342: Max Sum of a Pair With Equal Sum of Digits
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a 0-indexed array nums consisting of positive integers.
 * You can choose two indices i and j, such that i != j,
 *  and the sum of digits of the number nums[i] is equal to that of nums[j].
 * Return the maximum value of nums[i] + nums[j]
 * that you can obtain over all possible indices i and j that satisfy the conditions.
 */

import java.util.HashMap;
import java.util.Map;

public class MaxSumPairWithEqualSumDigits_2342 {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();

        for (int n : nums) {
            int sum = 0;
            int num = n;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            int[] maxPair = map.computeIfAbsent(sum, key -> new int[] { -1, -1 });

            if (n > maxPair[0]) {
                maxPair[1] = maxPair[0];
                maxPair[0] = n;
            } else if (n > maxPair[1]) {
                maxPair[1] = n;
            }
        }

        int maxVal = -1;
        for (int[] maxPair : map.values()) {
            if (maxPair[1] != -1) {
                maxVal = Math.max(maxVal, maxPair[0] + maxPair[1]);
            }
        }

        return maxVal;
    }
}
