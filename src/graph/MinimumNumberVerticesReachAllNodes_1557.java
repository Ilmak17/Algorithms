package graph;

/*
 * LeetCode Problem 1557: Minimum Number of Vertices to Reach All Nodes
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a directed acyclic graph, with n vertices numbered from 0 to n-1, and an array edges where
 * edges[i] = [fromi, toi] represents a directed edge from node fromi to node toi.
 * Find the smallest set of vertices from which all nodes in the graph are reachable.
 * It's guaranteed that a unique solution exists.
 * Notice that you can return the vertices in any order.
 */


import java.util.ArrayList;
import java.util.List;

public class MinimumNumberVerticesReachAllNodes_1557 {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];

        for (List<Integer> edge : edges) {
            inDegree[edge.get(1)]++;
            outDegree[edge.get(0)]++;
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0 && outDegree[i] > 0) {
                res.add(i);
            }
        }

        return res;
    }
}
