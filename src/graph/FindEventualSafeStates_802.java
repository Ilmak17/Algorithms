package graph;

/*
 * LeetCode Problem 802: Find Eventual Safe States
 * Difficulty: Medium
 *
 * Problem Statement:
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i]
 * is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
 * A node is a terminal node if there are no outgoing edges. A node is a safe node
 * if every possible path starting from that node leads to a terminal node (or another safe node).
* Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
 */

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates_802 {
    private Boolean[] safe;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        safe = new Boolean[n];
        List<Integer> res = new ArrayList<>();
        for (int node = 0; node < n; node++) {
            if (dfs(graph, node)) {
                res.add(node);
            }
        }
        return res;
    }

    private boolean dfs(int[][] graph, int node) {
        if (safe[node] != null) {
            return safe[node];
        }

        safe[node] = false;
        for (int nei : graph[node]) {
            if (!dfs(graph, nei)) {
                return false;
            }
        }
        safe[node] = true;

        return true;
    }
}
