
package arrayshashing;

/*
 * LeetCode Problem 3105: Longest Strictly Increasing or Strictly Decreasing Subarray
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given an array of integers nums. Return the length of the longest subarray of nums which is either
 * strictly increasing or strictly decreasing.
 */
public class LongestStrictlyIncreasingStrictlyDecreasingSubarray_3105 {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int maxLen = 1;
        int incLen = 1;
        int decLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1;
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1;
            } else {
                incLen = 1;
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }
}
