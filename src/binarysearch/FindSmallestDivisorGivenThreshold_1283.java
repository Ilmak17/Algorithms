package binarysearch;

/*
 * LeetCode Problem 1283: Find the Smallest Divisor Given a Threshold
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of integers nums and an integer threshold,
 * we will choose a positive integer divisor, divide all the array by it,
 *  and sum the division's result. Find the smallest divisor such that the result
 * mentioned above is less than or equal to threshold.
 * Each result of the division is rounded to the nearest integer greater than or equal to that element.
 *  (For example: 7/3 = 3 and 10/2 = 5).
* The test cases are generated so that there will be an answer.
 */

public class FindSmallestDivisorGivenThreshold_1283 {

    public int smallestDivisor(int[] nums, int threshold) {
        int maxVal = Integer.MIN_VALUE;

        for (int n : nums) maxVal = Math.max(maxVal, n);

        int left = 1;
        int right = maxVal;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (getSumOfDivisions(nums, mid) <= threshold) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private int getSumOfDivisions(int[] nums, int diviser) {
        int sum = 0;

        for (int n : nums) {
            sum += (int) Math.ceil((double) n / diviser);
        }

        return sum;
    }
}
