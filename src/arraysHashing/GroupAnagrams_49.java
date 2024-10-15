package arraysHashing;

/*
 * LeetCode Problem 49: Group Anagrams
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String sortedString = new String(chs);

            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }

            map.get(sortedString).add(str);
        }


        return new ArrayList<>(map.values());
    }
}
