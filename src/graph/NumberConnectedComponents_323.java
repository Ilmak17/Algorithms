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

class UnionFind {
    private final int[] parent;
    private final int[] rank;
    private int components;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xSet = find(x);
        int ySet = find(y);

        if (xSet == ySet) {
            return;
        }

        if (rank[xSet] > rank[ySet]) {
            parent[ySet] = xSet;
        } else if (rank[xSet] < rank[ySet]) {
            parent[xSet] = ySet;
        } else {
            parent[ySet] = xSet;
            rank[xSet]++;
        }
        components--;
    }

    public int getComponents() {
        return components;
    }
}
