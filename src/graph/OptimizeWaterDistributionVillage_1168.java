package graph;

/*
 * LeetCode Problem 1168: Optimize Water Distribution in a Village
 * Difficulty: Hard
 *
 * Problem Statement:
 * There are n houses in a village. We want to supply water for all the houses
 * by building wells and laying pipes.
 * For each house i, we can either build a well inside it directly with cost
 * wells[i - 1] (note the -1 due to 0-indexing), or pipe in water from another well to it.
 * The costs to lay pipes between houses are given by the array pipes where each
 * pipes[j] = [house1j, house2j, costj] represents the cost to connect house1j and house2j
 * together using a pipe. Connections are bidirectional, and there could be multiple valid
 * connections between the same two houses with different costs.
 * Return the minimum total cost to supply water to all houses.

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OptimizeWaterDistributionVillage_1168 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<int[]> edges = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            edges.add(new int[]{0, i, wells[i - 1]});
        }
        for (int[] p : pipes) {
            edges.add(new int[]{p[0], p[1], p[2]});
        }

        edges.sort(Comparator.comparingInt(e -> e[2]));

        int sum = 0;
        int used = 0;
        for (int[] edge : edges) {
            int v = edge[0];
            int e = edge[1];
            int c = edge[2];

            if (union(v, e)) {
                sum += c;
                used++;
                if (used == n) break;
            }
        }

        return sum;
    }

    int[] parent, rank;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (rank[ra] < rank[rb]) {
            parent[ra] = rb;
        } else if (rank[ra] > rank[rb]) {
            parent[rb] = ra;
        } else {
            parent[rb] = ra;
            rank[ra]++;
        }
        return true;
    }
}
