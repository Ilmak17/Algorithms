package greedy;

/*
 * LeetCode Problem 763: Partition Labels
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a string s. We want to partition the string into as many parts
 * as possible so that each letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order,
 * the resultant string should be s.
 * Return a list of integers representing the size of these parts.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int border = 0;
        int start = 0;
        for (int j = 0; j < s.length(); j++) {
            border = Math.max(border, map.get(s.charAt(j)));

            if (j == border) {
                res.add(j - start + 1);
                start = j + 1;
            }
        }

        return res;
    }
}
