package graph;

/*
 * LeetCode Problem 1192: Critical Connections in a Network
 * Difficulty: Hard
 *
 * Problem Statement:
 * There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections
 * forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi.
 *  Any server can reach other servers directly or indirectly through the network.
 * A critical connection is a connection that, if removed, will make some servers unable to reach some other server.
 * Return all critical connections in the network in any order.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnectionsNetwork_1192 {
    private int timer = 1;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (List<Integer> connection : connections) {
            adj.computeIfAbsent(connection.get(0), k -> new ArrayList<>())
                    .add(connection.get(1));

            adj.computeIfAbsent(connection.get(1), k -> new ArrayList<>())
                    .add(connection.get(0));
        }

        boolean[] visited = new boolean[n];
        int[] insertions = new int[n];
        int[] lowInsertions = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0, -1, visited, insertions, lowInsertions, adj, bridges);

        return bridges;
    }

    private void dfs(int node, int parent, boolean[] visited, int[] insertions,
                     int[] lowInsertions, Map<Integer, List<Integer>> adj, List<List<Integer>> bridges) {

        visited[node] = true;
        insertions[node] = lowInsertions[node] = timer++;

        for (int nei : adj.get(node)) {
            if (nei == parent) continue;

            if (!visited[nei]) {
                dfs(nei, node, visited, insertions, lowInsertions, adj, bridges);

                lowInsertions[node] = Math.min(lowInsertions[node], lowInsertions[nei]);

                if (lowInsertions[nei] > insertions[node]) {
                    bridges.add(List.of(node, nei));
                }
            } else {
                lowInsertions[node] = Math.min(lowInsertions[node], insertions[nei]);
            }
        }
    }
}