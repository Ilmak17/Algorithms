
package graph;

/*
 * LeetCode Problem 1857: Largest Color Value in a Directed Graph
 * Difficulty: Hard
 *
 * Problem Statement:
 * There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.
 * You are given a string colors where colors[i] is a lowercase English letter representing the
 * color of the ith node in this graph (0-indexed). You are also given a 2D array edges where
 * edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.
 * A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there
 * is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is
 *  the number of nodes that are colored the most frequently occurring color along that path.
 * Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueDirectedGraph_1857 {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();

        // строим граф
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[n];
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }

        // DP: dp[node][color]
        int[][] dp = new int[n][26];

        // топологическая сортировка (Kahn’s algorithm)
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                dp[i][colors.charAt(i) - 'a'] = 1;
            }
        }

        int visited = 0;
        int ans = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            visited++;

            for (int c = 0; c < 26; c++) {
                ans = Math.max(ans, dp[u][c]);
            }

            for (int v : adj.get(u)) {
                for (int c = 0; c < 26; c++) {
                    dp[v][c] = Math.max(dp[v][c], dp[u][c] + (colors.charAt(v) - 'a' == c ? 1 : 0));
                }
                if (--inDegree[v] == 0) q.add(v);
            }
        }

        return visited == n ? ans : -1;
    }
}
