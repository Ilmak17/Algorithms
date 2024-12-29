package intervals;

/*
 * LeetCode Problem 253: Meeting Rooms II
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of meeting time interval objects consisting of start and end times
 * [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
 * find the minimum number of days required to schedule all meetings without any conflicts.
 */

import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval intrvl : intervals) {
            if (!minHeap.isEmpty() && intrvl.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.add(intrvl.end);
        }

        return minHeap.size();
    }
}
