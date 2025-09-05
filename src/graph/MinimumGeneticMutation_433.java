package graph;

/*
 * LeetCode Problem 433: Minimum Genetic Mutation
 * Difficulty: Medium
 *
 * Problem Statement:
 * A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.
 * Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation
 * is defined as one single character changed in the gene string.
 * For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
 * There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make
 * it a valid gene string.
 * Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number
 *  of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.
 * Note that the starting point is assumed to be valid, so it might not be included in the bank.
 */


import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation_433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 0;

        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene))
            return -1;

        Set<String> visited = new HashSet<>();
        char[] genes = new char[] { 'A', 'C', 'G', 'T' };

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startGene, 0));
        visited.add(startGene);

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            String gene = cur.word;
            int level = cur.steps;

            if (gene.equals(endGene))
                return level;

            char[] chars = gene.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char original = chars[i];
                for (char c : genes) {
                    if (c == original)
                        continue;

                    chars[i] = c;
                    String mutated = new String(chars);

                    if (bankSet.contains(mutated) && !visited.contains(mutated)) {
                        visited.add(mutated);
                        queue.add(new Pair(mutated, level + 1));
                    }
                }
                chars[i] = original;
            }
        }

        return -1;
    }
}