package arrayshashing;

/*
 * LeetCode Problem 406: Queue Reconstruction by Height
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given an array of people, people, which are the attributes of some people
 * in a queue (not necessarily in order). Each people[i] = [hi, ki] represents
 * the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
 * Reconstruct and return the queue that is represented by the input array people.
 * The returned queue should be formatted as an array queue, where queue[j] = [hj, kj]
 *  is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QueueReconstructionByHeight_406 {

    private void buildSegmentTree(int[] segmentTree, int index, int left, int right) {
        if (left == right) {
            segmentTree[index] = 1;
            return;
        }

        int mid = left + (right - left) / 2;
        buildSegmentTree(segmentTree, 2 * index + 1, left, mid);
        buildSegmentTree(segmentTree, 2 * index + 2, mid + 1, right);

        segmentTree[index] = segmentTree[2 * index + 1] + segmentTree[2 * index + 2];
    }

    private void query(int[] segmentTree, List<int[]> resultQueue,
                              int index, int left, int right, int position, int height, int originalPosition) {
        if (left == right) {
            resultQueue.set(left, new int[]{height, originalPosition});
            segmentTree[index]--;
            return;
        }
        if (segmentTree[index] < position) return;

        int mid = left + (right - left) / 2;

        if (segmentTree[2 * index + 1] >= position) {
            query(segmentTree, resultQueue, 2 * index + 1, left, mid, position, height, originalPosition);
        } else {
            query(segmentTree, resultQueue, 2 * index + 2, mid + 1, right, position - segmentTree[2 * index + 1], height, originalPosition);
        }

        segmentTree[index]--;
    }

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[] segmentTree = new int[4 * n];
        List<int[]> resultQueue = new ArrayList<>(Collections.nCopies(n, null));

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        buildSegmentTree(segmentTree, 0, 0, n - 1);

        for (int[] person : people) {
            query(segmentTree, resultQueue, 0, 0, n - 1, person[1] + 1, person[0], person[1]);
        }

        return resultQueue.toArray(new int[n][2]);
    }
}
