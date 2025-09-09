package graph;

/*
 * LeetCode Problem 1615: Maximal Network Rank
 * Difficulty: Medium
 *
 * Problem Statement:
 * There is an infrastructure of n cities with some number of roads connecting these cities. Each roads[i] = [ai, bi]
 * indicates that there is a bidirectional road between cities ai and bi.The network rank of two different cities
 * is defined as the total number of directly connected roads to either city. If a road is directly connected
 * to both cities, it is only counted once.
 * The maximal network rank of the infrastructure is the maximum network rank of all pairs of different cities.
 * Given the integer n and the array roads, return the maximal network rank of the entire infrastructure.
 */


import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximalNetworkRank_1615 {
    public int maximalNetworkRank(int n, int[][] roads) {
        int maxRank = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], k -> new HashSet<>()).add(road[1]);
            adj.computeIfAbsent(road[1], k -> new HashSet<>()).add(road[0]);
        }

        for (int node1 = 0; node1 < n; ++node1) {
            for (int node2 = node1 + 1; node2 < n; ++node2) {
                int currentRank = adj.getOrDefault(node1, Collections.emptySet()).size() +
                        adj.getOrDefault(node2, Collections.emptySet()).size();

                if (adj.getOrDefault(node1, Collections.emptySet()).contains(node2)) {
                    --currentRank;
                }
                maxRank = Math.max(maxRank, currentRank);
            }
        }

        return maxRank;
    }
}
