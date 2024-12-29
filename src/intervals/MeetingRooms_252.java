package intervals;

/*
 * LeetCode Problem 252: Meeting Rooms
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an array of meeting time interval objects consisting of start and end times
 * [[start_1,end_1],[start_2,end_2],...] (start_i < end_i),
 * determine if a person could add all meetings to their schedule without any conflicts.
 */

import java.util.List;

public class MeetingRooms_252 {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i - 1).end > intervals.get(i).start) {
                return false;
            }
        }

        return true;
    }
}
