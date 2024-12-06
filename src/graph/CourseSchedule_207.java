package graph;

/*
 * LeetCode Problem 207: Course Schedule
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 *  that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.


 */

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int n = edge[0];
            int e = edge[1];
            graph.get(n).add(e);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] cycleStack = new boolean[numCourses];

        for (int i = 0; i < graph.size(); i++) {
            if (dfs(graph, i, visited, cycleStack)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int node, boolean[] visited, boolean[] cycleStack) {
        if (cycleStack[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visited[node] = true;
        cycleStack[node] = true;
        for (Integer neighbour : graph.get(node)) {
            if (dfs(graph, neighbour, visited, cycleStack)) {
                return true;
            }
        }

        cycleStack[node] = false;

        return false;
    }
}