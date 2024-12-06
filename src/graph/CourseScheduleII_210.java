package graph;

/*
 * LeetCode Problem 210: Course Schedule II
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 *  You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 *  that you must take course bi first if you want to take course ai.
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */

import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII_210 {
    private final List<List<Integer>> graph = new ArrayList<>();
    private boolean[] visited;
    private boolean[] onStack;
    private int[] res;
    private int k;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            graph.get(edge[1]).add(edge[0]);
        }

        res = new int[numCourses];
        visited = new boolean[numCourses];
        onStack = new boolean[numCourses];
        k = numCourses - 1;

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && topologicalSortUtil(i)) {
                return new int[]{};
            }
        }

        return res;
    }

    private boolean topologicalSortUtil(int node) {
        if (onStack[node]) {
            return true;
        }
        if (visited[node]) {
            return false;
        }

        onStack[node] = true;
        visited[node] = true;

        for (Integer neighbour : graph.get(node)) {
            if (topologicalSortUtil(neighbour)) {
                return true;
            }
        }

        onStack[node] = false;
        res[k--] = node;

        return false;
    }
}