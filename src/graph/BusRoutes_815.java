package graph;

/*
 * LeetCode Problem 815: Bus Routes
 * Difficulty: Hard
 *
 * Problem Statement:
 * You are given an array routes representing bus routes where routes[i]
 * is a bus route that the ith bus repeats forever.
 * For example, if routes[0] = [1, 5, 7], this means that the 0th
 * bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
 * You will start at the bus stop source (You are not on any bus initially),
 * and you want to go to the bus stop target. You can travel between bus stops by buses only.
 * Return the least number of buses you must take to travel from source to target.
 * Return -1 if it is not possible.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes_815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int routeIndex = 0; routeIndex < routes.length; routeIndex++) {
            for (int stop : routes[routeIndex]) {
                stopToRoutes
                        .computeIfAbsent(stop, k -> new ArrayList<>())
                        .add(routeIndex);
            }
        }

        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{source, 0});

        Set<Integer> visitedStops = new HashSet<>();
        visitedStops.add(source);

        Set<Integer> usedRoutes = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int stop = curr[0];
            int buses = curr[1];

            for (int routeIdx : stopToRoutes.get(stop)) {
                if (usedRoutes.contains(routeIdx))
                    continue;
                usedRoutes.add(routeIdx);

                for (int nextStop : routes[routeIdx]) {
                    if (nextStop == target)
                        return buses + 1;
                    if (visitedStops.add(nextStop)) {
                        queue.add(new int[]{nextStop, buses + 1});
                    }
                }
            }
        }

        return -1;
    }
}
