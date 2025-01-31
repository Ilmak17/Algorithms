package graph;

/*
 * LeetCode Problem 743: Network Delay Time
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a network of n nodes, labeled from 1 to n. You are also given times,
 *  a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.
 * We will send a signal from a given node k. Return the minimum time it takes for all
 * the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] edge : times) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>())
                    .add(new int[] { edge[1], edge[2] });
        }


        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.add(new int[] { 0, k });

        Set<Integer> visited = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] cur = minHeap.poll();
            int w1 = cur[0];
            int n1 = cur[1];

            if (visited.contains(n1)) continue;
            visited.add(n1);
            t = w1;

            if (adj.containsKey(n1)) {
                for (int[] nei : adj.get(n1)) {
                    int n2 = nei[0];
                    int w2 = nei[1];
                    if (!visited.contains(n2)) {
                        minHeap.add(new int[]{w1 + w2, n2});
                    }
                }
            }
        }

        return visited.size() == n ? t : -1;
    }
}
