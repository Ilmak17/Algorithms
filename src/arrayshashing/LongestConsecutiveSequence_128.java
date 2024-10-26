package arrayshashing;

/*
 * LeetCode 128: Longest Consecutive Sequence
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 */


import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence_128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int el : nums) {
            set.add(el);
        }

        int longestSequence = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int curNum = n;
                int currentStreak = 1;

                while (set.contains(curNum + 1)) {
                    currentStreak += 1;
                    curNum += 1;
                }

                longestSequence = Math.max(longestSequence, currentStreak);
            }
        }

        return longestSequence;
    }
}
