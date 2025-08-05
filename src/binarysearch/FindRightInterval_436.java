package binarysearch;

/*
 * LeetCode Problem 436: Find Right Interval
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 * Note that i may equal j.
 * Return an array of right interval indices for each interval i. If no right interval exists for interval i,
 *  then put -1 at index i.
 */

import java.util.Arrays;

public class FindRightInterval_436 {
    public int[] findRightInterval(int[][] intervals) {
        int[][] starts = new int[intervals.length][2];
        int[][] ends = new int[intervals.length][2];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = new int[] { intervals[i][0], i };
            ends[i] = new int[] { intervals[i][1], i };
        }

        Arrays.sort(starts, (a, b) -> a[0] - b[0]);

        int[] response = new int[intervals.length];
        for (int[] end : ends) {
            response[end[1]] = search(starts, end[0]);
        }

        return response;
    }

    private int search(int[][] starts, int target) {
        int low = 0;
        int high = starts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (starts[mid][0] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low < starts.length ? starts[low][1] : -1;
    }
}
