package slidingwindow;

/*
 * LeetCode Problem 424: Longest Repeating Character Replacement
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a string s and an integer k. You can choose any character of the string and change
 *  it to any other uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter
 * you can get after performing the above operations.
 */

public class LongestRepeatingCharacterReplacement_424 {

    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];

        int maxSubstring = 0;
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++;

            max = Math.max(max, arr[s.charAt(right) - 'A']);

            while (right - left + 1 - max > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }

            maxSubstring = Math.max(maxSubstring, right - left + 1);
        }

        return maxSubstring;
    }
}
