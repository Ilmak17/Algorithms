package arrayshashing;

/*
 * LeetCode Problem 3066: Minimum Operations to Exceed Threshold Value II
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a 0-indexed integer array nums, and an integer k.
 * You are allowed to perform some operations on nums, where in a single operation, you can:
 * Select the two smallest integers x and y from nums
 * Remove x and y from nums.
 * Insert (min(x, y) * 2 + max(x, y)) at any position in the array.
 * Note that you can only apply the described operation if nums contains at least two elements.
 */

import java.util.PriorityQueue;

public class MinimumOperationsExceedThresholdValueII_3066 {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if (num < k) pq.add(num);
        }

        int operations = 0;

        while (!pq.isEmpty()) {
            int x = pq.poll();
            operations++;

            if (pq.isEmpty()) break;

            int y = pq.poll();
            long newValue = 2L * x + y;

            if (newValue < k) pq.add((int) newValue);
        }

        return operations;
    }
}
