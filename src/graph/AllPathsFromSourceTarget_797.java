package graph;

/*
 * LeetCode Problem 797: All Paths From Source to Target
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible
 * paths from node 0 to node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i
 * (i.e., there is a directed edge from node i to node graph[i][j]).
 */


import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceTarget_797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> allPaths = new ArrayList<>();

        iterate(0, graph, new ArrayList<>(List.of(0)), allPaths);

        return allPaths;
    }

    private void iterate(int node, int[][] graph, List<Integer> path, List<List<Integer>> allPaths) {
        if (node == graph.length - 1) {
            allPaths.add(new ArrayList<>(path));
            return;
        }

        for (int nei : graph[node]) {
            path.add(nei);
            iterate(nei, graph, path, allPaths);
            path.remove(path.size() - 1);
        }
    }
}