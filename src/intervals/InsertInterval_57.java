package intervals;

/*
 * LeetCode Problem 57: Insert Interval
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array of non-overlapping intervals intervals where
 *  intervals[i] = [starti, endi] represent the start and the end of the ith interval
 * and intervals is sorted in ascending order by starti. You are also given an interval
 * newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order
 * by starti and intervals still does not have any overlapping intervals
 * (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            res.add(new int[] { intervals[idx][0], intervals[idx][1] });
            idx++;
        }
        int start = newInterval[0];
        int end = newInterval[1];
        while (idx < intervals.length && intervals[idx][0] <= newInterval[1]) {
            start = Math.min(start, intervals[idx][0]);
            end = Math.max(end, intervals[idx][1]);
            idx++;
        }
        res.add(new int[] { start, end });

        while (idx < intervals.length) {
            res.add(new int[] { intervals[idx][0], intervals[idx][1] });
            idx++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
