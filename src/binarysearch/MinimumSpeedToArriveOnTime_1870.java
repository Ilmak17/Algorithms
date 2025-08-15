package binarysearch;

/*
 * LeetCode Problem 1870: Minimum Speed to Arrive on Time
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a floating-point number hour, representing the amount of time you have to reach the office.
 *  To commute to the office, you must take n trains in sequential order. You are also given an integer array dist
 * of length n, where dist[i] describes the distance (in kilometers) of the ith train ride.
 * Each train can only depart at an integer hour, so you may need to wait in between each train ride.
 * For example, if the 1st train ride takes 1.5 hours, you must wait for an additional 0.5 hours before you
 * can depart on the 2nd train ride at the 2 hour mark.
 * Return the minimum positive integer speed (in kilometers per hour) that all the trains must travel at for
 *  you to reach the office on time, or -1 if it is impossible to be on time.
 * Tests are generated such that the answer will not exceed 107 and hour will have at most
 *  two digits after the decimal point.
 */

public class MinimumSpeedToArriveOnTime_1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;

        if (hour <= n - 1)
            return -1;

        int low = 1;
        int high = 10_000_000;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            double t = timeNeeded(dist, mid);
            if (t <= hour) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low > 10_000_000 ? -1 : low;
    }

    private double timeNeeded(int[] dist, int speed) {
        int n = dist.length;
        double time = 0.0;

        for (int i = 0; i < n - 1; i++) {
            time += (dist[i] + speed - 1) / speed;
        }

        time += (double) dist[n - 1] / speed;

        return time;
    }
}
