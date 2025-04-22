package graph;

/*
 * LeetCode Problem 785: Is Graph Bipartite?
 * Difficulty: Medium
 *
 * Problem Statement:
 * There is an undirected graph with n nodes, where each node is numbered between 0 and n - 1.
 * You are given a 2D array graph, where graph[u] is an array of nodes that node u is adjacent to.
 *  More formally, for each v in graph[u], there is an undirected edge between node u and node v.
 * The graph has the following properties:
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent sets A and B such that every edge
 * in the graph connects a node in set A and a node in set B.
 * Return true if and only if it is bipartite.
 */

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        final UnionFind unionFind = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            if (graph[i].length == 0) continue;

            int firstNeighbour = graph[i][0];

            for (int neighbor : graph[i]) {
                if (unionFind.find(i) == unionFind.find(neighbor)) {
                    return false;
                }
                unionFind.union(firstNeighbour, neighbor);
            }
        }

        return true;
    }

    private boolean isBipartite2(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !bfs(i, n, graph, color)) return false;

        }

        return true;
    }

    private boolean bfs(int start, int n, int[][] graph, int[] color) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        color[start] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : graph[cur]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[cur];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[cur]) return false;
            }
        }

        return true;
    }
}
