package graph;

/*
 * LeetCode Problem 1376: Time Needed to Inform All Employees
 * Difficulty: Medium
 *
 * Problem Statement:
 * A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the
 * one with headID.
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee,
 * manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
 * The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct
 * subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes,
 * all his direct subordinates can start spreading the news).
 * Return the number of minutes needed to inform all the employees about the urgent news.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededInformAllEmployees_1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < manager.length; i++) {
            if (manager[i] != -1) {
                adj.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { headID, 0 });
        int maxTime = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int node = cur[0];
            int time = cur[1];
            maxTime = Math.max(time, maxTime);

            for (int nei : adj.getOrDefault(node, Collections.emptyList())) {
                queue.add(new int[] { nei, time + informTime[node] });
            }
        }

        return maxTime;
    }
}