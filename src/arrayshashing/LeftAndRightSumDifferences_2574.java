package arrayshashing;

/*
 * LeetCode Problem 2574: Left and Right Sum Differences
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given a 0-indexed integer array nums, find a 0-indexed integer array answer where:
 * answer.length == nums.length.
 * answer[i] = |leftSum[i] - rightSum[i]|.
 * Where:
 * leftSum[i] is the sum of elements to the left of the index i in the array nums.
 *  If there is no such element, leftSum[i] = 0.
 * rightSum[i] is the sum of elements to the right of the index i in the array nums.
 *  If there is no such element, rightSum[i] = 0.
 * Return the array answer.
 */

public class LeftAndRightSumDifferences_2574 {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int totalSum = 0;
        for (int el : nums) totalSum += el;

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            res[i] = Math.abs(leftSum - rightSum);
            leftSum += nums[i];
        }

        return res;
    }
}
