package slidingwindow;

/*
 * LeetCode Problem 2762: Continuous Subarrays
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:
 * Let i, i + 1, ..., j be the indices in the subarray.
 * Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
 * Return the total number of continuous subarrays.
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ContinuousSubarrays_2762 {
    Deque<Integer> maxQ;
    Deque<Integer> minQ;

    public int getMaxInSubarray() {
        return maxQ.size() == 0 ? -1 : maxQ.peekFirst();
    }

    public int getMinInSubarray() {
        return minQ.size() == 0 ? -1 : minQ.peekFirst();
    }

    public long continuousSubarrays(int[] nums) {
        minQ = new ArrayDeque<>();
        maxQ = new ArrayDeque<>();

        int left = 0;
        int right = 0;
        long ans = 0;
        int n = nums.length;

        while (right < n) {
            while (maxQ.size() > 0 && maxQ.peekLast() < nums[right]) {
                maxQ.removeLast();
            }
            while (minQ.size() > 0 && minQ.peekLast() > nums[right]) {
                minQ.removeLast();
            }
            maxQ.addLast(nums[right]);
            minQ.addLast(nums[right]);

            while (getMaxInSubarray() - getMinInSubarray() > 2) {
                if (maxQ.size() > 0 && maxQ.peekFirst() == nums[left]) {
                    maxQ.removeFirst();
                }
                if (minQ.size() > 0 && minQ.peekFirst() == nums[left]) {
                    minQ.removeFirst();
                }
                left++;
            }

            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
