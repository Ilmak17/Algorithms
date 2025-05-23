package graph;

/*
 * LeetCode Problem 1319: Number of Operations to Make Network Connected
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming
 * a network where connections[i] = [ai, bi] represents a connection between computers ai and bi.
 *  Any computer can reach any other computer directly or indirectly through the network.
 * You are given an initial computer network connections. You can extract certain cables between
 *  two directly connected computers, and place them between any pair of disconnected computers
 * to make them directly connected.
 * Return the minimum number of times you need to do this in order to make all the computers connected.
 *  If it is not possible, return -1.
 */

public class NumberOperationsMakeNetworkConnected_1319 {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        UnionFind uf = new UnionFind(n);

        for (int[] con : connections) {
            uf.union(con[0], con[1]);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == i) {
                count++;
            }
        }

        return count - 1;
    }
}
