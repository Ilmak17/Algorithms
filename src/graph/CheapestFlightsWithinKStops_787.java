
package graph;

/*
 * LeetCode Problem 787: Cheapest Flights Within K Stops
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are n cities connected by some number of flights.
 * You are given an array flights where flights[i] = [fromi, toi, pricei]
 * indicates that there is a flight from city fromi to city toi with cost pricei.
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CheapestFlightsWithinKStops_787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] fl : flights) {
            adj.computeIfAbsent(fl[0], t -> new ArrayList<>())
                    .add(new int[] { fl[1], fl[2] });
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { 0, 0, src }); // steps price node

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int steps = cur[0];
            int price = cur[1];
            int node = cur[2];

            if (steps > k)
                continue;
            if (adj.containsKey(node)) {
                for (int[] nei : adj.get(node)) {
                    int neiNode = nei[0];
                    int neiPrice = nei[1];

                    if (price + neiPrice < dist[neiNode]) {
                        dist[neiNode] = price + neiPrice;
                        q.add(new int[] { steps + 1, dist[neiNode], neiNode });
                    }
                }
            }

        }

        return dist[dst] != Integer.MAX_VALUE ? dist[dst] : -1;
    }
}
