package arrayshashing;

/*
 * LeetCode Problem 370: Range Addition
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an integer length and an array updates where updates[i] = [startIdxi, endIdxi, inci].
 * You have an array arr of length length with all zeros, and you have some operation to apply on arr.
 * In the ith operation, you should increment all the elements
 * arr[startIdxi], arr[startIdxi + 1], ..., arr[endIdxi] by inci.
 * Return arr after applying all the updates.
 */

public class RangeAddition_370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] arr = new int[length];

        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int inc = update[2];

            arr[start] += inc;

            if (end + 1 < length) {
                arr[end + 1] -= inc;
            }
        }

        for (int i = 1; i < length; i++) {
            arr[i] += arr[i - 1];
        }

        return arr;
    }
}
