package heap;

/*
 * LeetCode Problem 973: K Closest Points to Origin
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 */

import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
                Integer.compare((b[0] * b[0] + b[1] * b[1]), (a[0] * a[0] + a[1] * a[1]))
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int idx = 0;
        while (!maxHeap.isEmpty()) {
            res[idx++] = maxHeap.poll();
        }

        return res;
    }
}
