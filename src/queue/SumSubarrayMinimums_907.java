package queue;

/*
 * LeetCode Problem 907: Sum of Subarray Minimums
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers arr, find the sum of min(b),
 * where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7.
 */

import java.util.Deque;
import java.util.LinkedList;

public class SumSubarrayMinimums_907 {
    private static final int MOD = 1_000_000_007;

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long result = 0;
        Deque<Integer> monotonicQueue = new LinkedList<>();

        for (int currentIndex = 0; currentIndex <= n; currentIndex++) {
            int currentElement = currentIndex == n ? 0 : arr[currentIndex];

            while (!monotonicQueue.isEmpty() && arr[monotonicQueue.peekLast()] > currentElement) {
                int minElementIndex = monotonicQueue.pollLast();
                int previousIndex = monotonicQueue.isEmpty() ? -1 : monotonicQueue.peekLast();

                int countSubarrays = (minElementIndex - previousIndex) * (currentIndex - minElementIndex);

                result = (result + (long) arr[minElementIndex] * countSubarrays % MOD) % MOD;
            }

            monotonicQueue.offerLast(currentIndex);
        }

        return (int) (result % MOD);
    }
}
