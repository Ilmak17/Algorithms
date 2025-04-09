package slidingwindow;

/*
 * LeetCode Problem 1358: Number of Substrings Containing All Three Characters
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a string s consisting only of characters a, b and c.
 * Return the number of substrings containing at least one occurrence of all these characters a, b and c.
 */

public class NumberSubstringsContainingAllThreeCharacters_1358 {
    public int numberOfSubstrings(String s) {
        int[] lastSeen = {-1, -1, -1};

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }

        return count;
    }
}
