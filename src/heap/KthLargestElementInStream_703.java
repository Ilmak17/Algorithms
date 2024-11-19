package heap;

/*
 * LeetCode Problem 703: Kth Largest Element in a Stream
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are part of a university admissions office
 *  and need to keep track of the kth highest test score from applicants in real-time.
 *  This helps to determine cut-off marks for interviews and admissions dynamically
 * as new applicants submit their scores.
 * You are tasked to implement a class which, for a given integer k,
 *  maintains a stream of test scores and continuously returns the kth highest test score
 *  after a new score has been submitted. More specifically,
 *  we are looking for the kth highest score in the sorted list of all scores.
 */

import java.util.PriorityQueue;

public class KthLargestElementInStream_703 {
    private final PriorityQueue<Integer> q;
    private final int k;

    public KthLargestElementInStream_703(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<>();

        for (int el : nums) {
            add(el);
        }
    }

    public int add(int val) {
        if (k > q.size()) {
            q.add(val);
        } else if (val >= q.peek()) {
            q.poll();
            q.add(val);
        }

        return q.peek();
    }
}
