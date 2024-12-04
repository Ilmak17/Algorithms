package graph;

/*
 * LeetCode Problem 323: Number of Connected Components in an Undirected Graph
 * Difficulty: Medium
 *
 * Problem Statement:
 * There is an undirected graph with n nodes. There is also an edges array,
 * where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
 * The nodes are numbered from 0 to n - 1.
 * Return the total number of connected components in that graph.
 */

public class NumberConnectedComponents_323 {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        return unionFind.getComponents();
    }
}