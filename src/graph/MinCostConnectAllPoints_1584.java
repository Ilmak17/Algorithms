package graph;

/*
 * LeetCode Problem 1584: Min Cost to Connect All Points
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|,
 *  where |val| denotes the absolute value of val.
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path
 *  between any two points.
 */

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostConnectAllPoints_1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int cost = 0;

        minHeap.add(new int[]{0, 0});
        while (visited.size() < n) {
            int[] cur = minHeap.poll();
            int wei = cur[0];
            int node = cur[1];

            if (visited.contains(node)) continue;

            visited.add(node);
            cost += wei;

            for (int i = 0; i < n; i++) {
                if (!visited.contains(i)) {
                    int dist =
                            Math.abs(points[node][0] - points[i][0]) +
                                    Math.abs(points[node][1] - points[i][1]);
                    minHeap.add(new int[]{dist, i});
                }
            }
        }

        return cost;
    }
}
