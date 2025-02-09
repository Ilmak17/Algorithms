package graph;

/*
 * LeetCode Problem 1514: Path with Maximum Probability
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an undirected weighted graph of n nodes (0-indexed), represented by an edge list
 * where edges[i] = [a, b] is an undirected edge connecting the nodes a and b with a probability
 * of success of traversing that edge succProb[i].
 * Given two nodes start and end, find the path with the maximum probability of success to go from start
 *  to end and return its success probability.
 * If there is no path from start to end, return 0. Your answer will be accepted if
 * it differs from the correct answer by at most 1e-5.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PathMaximumProbability_1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, i});
            adj.computeIfAbsent(v, key -> new ArrayList<>()).add(new int[]{u, i});
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        pq.add(new double[]{1.0, start_node});

        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;

        while (!pq.isEmpty()) {
            double prob = pq.peek()[0];
            int node = (int) pq.poll()[1];

            if (node == end_node) return prob;

            for (int[] neighbor : adj.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                double edgeProb = succProb[neighbor[1]];

                if (maxProb[nextNode] < maxProb[node] * edgeProb) {
                    maxProb[nextNode] = maxProb[node] * edgeProb;
                    pq.add(new double[]{maxProb[nextNode], nextNode});
                }
            }
        }

        return 0.0;
    }
}
