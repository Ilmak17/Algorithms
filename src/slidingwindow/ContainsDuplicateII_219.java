package slidingwindow;

/*
 * LeetCode Problem 219: Contains Duplicate II
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given an integer array nums and an integer k,
 * return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */


import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (set.contains(nums[r])) {
                return true;
            }
            set.add(nums[r]);
            if (r >= k) {
                set.remove(nums[l]);
                l++;
            }
        }

        return false;
    }
}
