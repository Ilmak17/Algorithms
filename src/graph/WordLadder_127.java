package graph;

/*
 * LeetCode Problem 802: Find Eventual Safe States
 * Difficulty: Medium
 *
 * Problem Statement:
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList
 * is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList,
 * return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}

public class WordLadder_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        Set<String> visited = new HashSet<>(wordList);
        visited.remove(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int steps = pair.steps;

            if (word.equals(endWord)) return steps;

            for (int i = 0; i < word.length(); i++) {
                char[] chrs = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chrs[i] = ch;
                    String newWord = new String(chrs);

                    if (visited.contains(newWord)) {
                        queue.add(new Pair(newWord, steps + 1));
                        visited.remove(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
