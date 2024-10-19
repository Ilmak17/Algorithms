package twopointers;

/*
 * LeetCode Problem 15: 3Sum
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 *  such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int val = nums[i] + nums[left] + nums[right];

                if (val == 0) {
                    res.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    right--;
                    left++;
                } else if (val > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }
}
