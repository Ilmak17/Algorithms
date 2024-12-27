package intervals;

/*
 * LeetCode Problem 56: Merge Intervals
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals,
 *  and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            if (end >= interval[0]) {
                end = Math.max(end, interval[1]);
            } else {
                res.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}
