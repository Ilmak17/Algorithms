package graph;

/*
 * LeetCode Problem 286: Walls And Gates
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a m×n m×n 2D grid initialized with these three possible values:
 * -1 - A water cell that can not be traversed.
 * 0 - A treasure chest.
 * INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
 * Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest than the value should remain INF.
 * Assume the grid can only be traversed up, down, left, or right.
 */

public class RedundantConnection_684 {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            if (unionFind.find(node1) == unionFind.find(node2)) {
                return edge;
            }

            unionFind.union(node1, node2);
        }

        return new int[2];
    }
}
