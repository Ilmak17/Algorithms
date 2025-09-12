package slidingwindow;

/*
 * LeetCode Problem 239: Sliding Window Maximum
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array of integers nums, there is a
 * sliding window of size k which is moving from the very left
 * of the array to the very right. You can only see the k numbers in the window.
 * Each time the sliding window moves right by one position.
 * Return the max sliding window.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0) return new int[0];

        int[] answer = new int[len - k + 1];
        int idx = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int right = 0; right < len; right++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);

            if (deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            if (right >= k - 1) {
                answer[idx++] = nums[deque.peekFirst()];
            }
        }

        return answer;
    }
}
