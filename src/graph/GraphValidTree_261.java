package graph;

/*
 * LeetCode Problem 261: Graph Valid Tree
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphValidTree_261 {
    private final List<List<Integer>> graph = new ArrayList<>();
    private Set<Integer> visited;

    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }
        createGraph(n, edges);

        return !isCycle(0, -1) && visited.size() == n;
    }

    private boolean isCycle(int node, int parent) {
        visited.add(node);

        for (Integer neighbour : graph.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (visited.contains(neighbour) || isCycle(neighbour, node)) {
                return true;
            }
        }

        return false;
    }

    private void createGraph(int n, int[][] edges) {
        visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }
}
