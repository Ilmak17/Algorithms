package heap;

/*
 * LeetCode Problem 215: Kth Largest Element in an Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */

import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
