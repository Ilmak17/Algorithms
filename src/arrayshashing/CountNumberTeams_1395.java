package arrayshashing;

/*
 * LeetCode Problem 1395: Count Number of Teams
 * Difficulty: Medium
 *
 * Problem Statement:
 * There are n soldiers standing in a line. Each soldier is assigned a unique rating value.
 * You have to form a team of 3 soldiers amongst them under the following rules:
 * Choose 3 soldiers with index (i, j, k) with rating (rating[i], rating[j], rating[k]).
 * A team is valid if: (rating[i] < rating[j] < rating[k]) or (rating[i] > rating[j] > rating[k]) where (0 <= i < j < k < n).
 * Return the number of teams you can form given the conditions. (soldiers can be part of multiple teams).
 */

import java.util.Arrays;

public class CountNumberTeams_1395 {
ав
    public void update(int index, int value, int low, int high, int position, int[] segTree) {
        if (low == high) {
            segTree[index] += value;
        } else {
            int mid = low + (high - low) / 2;

            if (position <= mid && position >= low) {
                update(2 * index + 1, value, low, mid, position, segTree);
            } else {
                update(2 * index + 2, value, mid + 1, high, position, segTree);
            }
            segTree[index] = segTree[2 * index + 1] + segTree[2 * index + 2];
        }
    }

    private int sumRange(int left, int right, int low, int high, int index, int[] segTree) {
        if (low >= left && high <= right) {
            return segTree[index];
        }
        if (right < low || high < left) {
            return 0;
        }
        int mid = (low + high) / 2;
        return sumRange(left, right, low, mid, 2 * index + 1, segTree) +
                sumRange(left, right, mid + 1, high, 2 * index + 2, segTree);
    }

    public int numTeams(int[] ratings) {
        int teamCount = 0;
        int maxRating = Arrays.stream(ratings).max().getAsInt() + 1;
        int[] leftSegmentTree = new int[4 * maxRating];
        int[] rightSegmentTree = new int[4 * maxRating];

        for (int i = 1; i < ratings.length; i++) {
            update(0, 1, 0, maxRating - 1, ratings[i], rightSegmentTree);
        }

        update(0, 1, 0, maxRating - 1, ratings[0], leftSegmentTree);

        for (int i = 1; i < ratings.length; i++) {
            int leftLessCount = sumRange(0, ratings[i] - 1, 0, maxRating - 1, 0, leftSegmentTree);
            int rightGreaterCount = sumRange(ratings[i] + 1, maxRating - 1, 0, maxRating - 1, 0, rightSegmentTree);
            teamCount += leftLessCount * rightGreaterCount;
            int leftGreaterCount = sumRange(ratings[i] + 1, maxRating - 1, 0, maxRating - 1, 0, leftSegmentTree);
            int rightLessCount = sumRange(0, ratings[i] - 1, 0, maxRating - 1, 0, rightSegmentTree);
            teamCount += leftGreaterCount * rightLessCount;
            update(0, 1, 0, maxRating - 1, ratings[i], leftSegmentTree);
            update(0, -1, 0, maxRating - 1, ratings[i], rightSegmentTree);
        }

        return teamCount;
    }
}
