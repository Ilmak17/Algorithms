package graph;

/*
 * LeetCode Problem 269: Alien Dictionary
 * Difficulty: Hard
 * Problem Statement:
 * There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.
 * You are given a list of strings words from the alien language's dictionary.
 * Now it is claimed that the strings in words are sorted lexicographically by the rules of this new language.
 * If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".
 * Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically
 * increasing order by the new language's rules. If there are multiple solutions, return any of them.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary_269 {
    public String alienOrder(String[] words) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                int key = c - 'a';
                adj.putIfAbsent(key, new ArrayList<>());
                inDegree.putIfAbsent(key, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int min = Math.min(s1.length(), s2.length());

            if (s1.startsWith(s2) && s1.length() > s2.length()) return "";

            for (int j = 0; j < min; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int from = s1.charAt(j) - 'a';
                    int to = s2.charAt(j) - 'a';
                    adj.get(from).add(to);
                    inDegree.put(to, inDegree.get(to) + 1);
                    break;
                }
            }
        }

        List<Integer> list = topoSort(adj, inDegree);
        if (list.size() < inDegree.size()) return "";

        StringBuilder builder = new StringBuilder();
        for (int el : list) {
            builder.append((char) ('a' + el));
        }

        return builder.toString();
    }

    private List<Integer> topoSort(Map<Integer, List<Integer>> adj,
                                   Map<Integer, Integer> inDegree) {
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) queue.add(entry.getKey());
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for (int nei : adj.get(node)) {
                inDegree.put(nei, inDegree.get(nei) - 1);
                if (inDegree.get(nei) == 0) {
                    queue.add(nei);
                }
            }
        }

        return res;
    }
}