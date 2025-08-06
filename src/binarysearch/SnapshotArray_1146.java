package binarysearch;

/*
 * LeetCode Problem 1146: Snapshot Array
 * Difficulty: Medium
 *
 * Problem Statement:
 * Implement a SnapshotArray that supports the following interface:
 * SnapshotArray(int length) initializes an array-like data structure with
 *  the given length. Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of
 *  times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the
 * snapshot with the given snap_id
 */

import java.util.ArrayList;
import java.util.List;

class Snap {
    int snapId;
    int value;

    public Snap(int snapId, int value) {
        this.snapId = snapId;
        this.value = value;
    }
}

public class SnapshotArray_1146 {

    private final List<List<Snap>> history;
    private int currentSnapId;

    public SnapshotArray_1146(int length) {
        history = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            List<Snap> list = new ArrayList<>();
            list.add(new Snap(0, 0));
            history.add(list);
        }
        currentSnapId = 0;
    }

    public void set(int index, int val) {
        List<Snap> nodes = history.get(index);
        if (nodes.get(nodes.size() - 1).snapId == currentSnapId) {
            nodes.get(nodes.size() - 1).value = val;
        } else {
            nodes.add(new Snap(currentSnapId, val));
        }
    }

    public int snap() {
        return currentSnapId++;
    }

    public int get(int index, int snap_id) {
        List<Snap> nodes = history.get(index);
        int low = 0;
        int high = nodes.size() - 1;
        int res = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nodes.get(mid).snapId <= snap_id) {
                res = nodes.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
