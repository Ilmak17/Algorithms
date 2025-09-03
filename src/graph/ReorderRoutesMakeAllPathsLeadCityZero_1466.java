package graph;

/*
 * LeetCode Problem 1466: Reorder Routes to Make All Paths Lead to the City Zero
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between
 *  two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads
 * in one direction because they are too narrow.
 * Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.
 * This year, there will be a big event in the capital (city 0), and many people want to travel to this city.
 * Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.
 * It's guaranteed that each city can reach city 0 after reorder.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutesMakeAllPathsLeadCityZero_1466 {
    static class Node {
        int node;
        boolean isInDegree;

        public Node(int node, boolean isInDegree) {
            this.node = node;
            this.isInDegree = isInDegree;
        }
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Node>> adj = new HashMap<>();

        for (int[] con : connections) {
            adj.computeIfAbsent(con[0], k -> new ArrayList<>())
                    .add(new Node(con[1], false));

            adj.computeIfAbsent(con[1], k -> new ArrayList<>())
                    .add(new Node(con[0], true));
        }

        boolean[] visited = new boolean[n];
        return estimateMinReorder(0, visited, adj);
    }

    private int estimateMinReorder(int node, boolean[] visited, Map<Integer, List<Node>> adj) {
        visited[node] = true;
        int count = 0;
        for (Node nei : adj.get(node)) {
            if (visited[nei.node]) continue;
            if (!nei.isInDegree) count++;
            count += estimateMinReorder(nei.node, visited, adj);
        }

        return count;
    }
}