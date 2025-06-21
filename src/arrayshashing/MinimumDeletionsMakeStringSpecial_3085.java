package arrayshashing;

/*
 * LeetCode Problem 3085: Minimum Deletions to Make String K-Special
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a string word and an integer k.
 * We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
 * Here, freq(x) denotes the frequency of the character x in word, and |y| denotes the absolute value of y.
 * Return the minimum number of characters you need to delete to make word k-special.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDeletionsMakeStringSpecial_3085 {
    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char ch : word.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(freq.values());
        Collections.sort(counts);

        int minDeletions = Integer.MAX_VALUE;

        for (int i = 0; i < counts.size(); i++) {
            int target = counts.get(i);
            int deletions = 0;

            for (int count : counts) {
                if (count < target) {
                    deletions += count; // удалить все
                } else if (count > target + k) {
                    deletions += (count - (target + k)); // удалить лишние
                }
            }

            minDeletions = Math.min(minDeletions, deletions);
        }

        return minDeletions;
    }
}
