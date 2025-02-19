package slidingwindow;

/*
 * LeetCode Problem 1438: Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers nums and an integer limit,
 * return the size of the longest non-empty subarray such
 * that the absolute difference between any two elements of this subarray is less than or equal to limit.
 */

import java.util.Deque;
import java.util.LinkedList;

public class LongestContinuousSubarrayAbsoluteDiffLessThanEqualLimit_1438 {

    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int start = 0;
        int maxLength = 0;
        for (int end = 0; end < nums.length; end++) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[end]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(end);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[end]) {
                minDeque.pollLast();
            }
            minDeque.addLast(end);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                start++;
                if (maxDeque.peekFirst() < start) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < start) {
                    minDeque.pollFirst();
                }
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
