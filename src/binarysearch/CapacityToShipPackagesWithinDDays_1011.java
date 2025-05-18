package binarysearch;

/*
 * LeetCode Problem 1011: Capacity To Ship Packages Within D Days
 * Difficulty: Medium
 *
 * Problem Statement:
 * A conveyor belt has packages that must be shipped from one port to another within days.
 * The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with packages
 *  on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight
 *  capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped
 * within days.
 */

public class CapacityToShipPackagesWithinDDays_1011 {

    public int shipWithinDays(int[] weights, int days) {

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int w : weights) {
            max = Math.max(w, max);
            sum += w;
        }

        int low = max;
        int high = sum;
        int ans = 0;
        while (low <= high) {
            // to prevent overflow
            int mid = low + (high - low) / 2;

            if (getDays(weights, mid) <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int getDays(int[] weights, int wei) {
        int count = 1;
        int curWei = 0;

        for (int w : weights) {
            if (curWei + w > wei) {
                curWei = w;
                count++;
            } else {
                curWei += w;
            }
        }

        return count;
    }
}
