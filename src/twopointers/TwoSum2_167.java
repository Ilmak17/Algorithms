package twopointers;

/*
 * LeetCode Problem 167: Two Sum II - Input Array Is Sorted
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1]
 * and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 * Your solution must use only constant extra space.
 */


import java.util.Arrays;
import java.util.Comparator;

public class TwoSum2_167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int val = numbers[left] + numbers[right];
            if (val == target) {
                return new int[]{left + 1, right + 1};
            } else if (val > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{};
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];

        int[][] eleIndex = new int[n][2];
        for (int i = 0; i < nums.length; i++) {
            eleIndex[i][0] = nums[i];
            eleIndex[i][1] = i;
        }
        Arrays.sort(eleIndex, Comparator.comparingInt(a -> a[0]));

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = eleIndex[left][0] + eleIndex[right][0];

            if (sum == target) {
                ans[0] = eleIndex[left][1];
                ans[1] = eleIndex[right][1];
                return ans;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}
