package stack;

/*
 * LeetCode Problem 85: Car Fleet
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.
 * You are given two integer array position and speed, both of length n,
 *  where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.
 * A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.
 * A car fleet is a car or cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.
 * If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.
 * Return the number of car fleets that will arrive at the destination.
 */


public class CarFleet_853 {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length != speed.length) {
            return 0;
        }

        Stack<Double> stack = new Stack<>();
        int[][] combine = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            combine[i][0] = position[i];
            combine[i][1] = speed[i];
        }

        Arrays.sort(combine, (a, b) -> a[0] - b[0]);
        for (int i = combine.length - 1; i >= 0; i--) {
            double currentTime = (double) (target - combine[i][0]) /
                    combine[i][1];
            if (!stack.isEmpty() && stack.peek() >= currentTime) {
                continue;
            } else {
                stack.push(currentTime);
            }
        }


        return stack.size();
    }
}
