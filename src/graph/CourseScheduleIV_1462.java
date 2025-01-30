package graph;

/*
 * LeetCode Problem 1462: Course Schedule IV
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course ai first if you want to take course bi.
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1.
 * Prerequisites can also be indirect. If course a is a prerequisite of course b, and course b is a
 * prerequisite of course c, then course a is a prerequisite of course c.
 * You are also given an array queries where queries[j] = [uj, vj]. For the jth query,
 *  you should answer whether course uj is a prerequisite of course vj or not.
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleIV_1462 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[][] reachable = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
            reachable[edge[0]][edge[1]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();

            for (int neighbor : adjList.get(course)) {
                for (int i = 0; i < numCourses; i++) {
                    if (reachable[i][course]) {
                        reachable[i][neighbor] = true;
                    }
                }

                if (--inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }
}
