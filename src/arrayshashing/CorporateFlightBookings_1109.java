package arrayshashing;

/*
 * LeetCode Problem 1109: Corporate Flight Bookings
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are n flights that are labeled from 1 to n.
 * You are given an array of flight bookings bookings,
 *  where bookings[i] = [firsti, lasti, seatsi] represents
 * a booking for flights firsti through lasti (inclusive)
 * with seatsi seats reserved for each flight in the range.
 * Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
 */

public class CorporateFlightBookings_1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 1) initialize arr
        int[] arr = new int[n];

        // 2) iterate through bookings
        for (int[] booking : bookings) {
            // 3) get values from booking[i]
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];

            // 4) increment value for arr[i] with seats
            arr[first - 1] += seats;

            // 5) check if there value end + 1
            if (last < n) {
                // 1. if exist decrement arr[end + 1] with seats
                arr[last] -= seats;
            }
        }

        // 6) do prefix sum
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        // 7) return value
        return arr;
    }
}
