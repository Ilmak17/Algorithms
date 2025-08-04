package binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * LeetCode Problem 981: Time Based Key-Value Store
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design a time-based key-value data structure that can store multiple values
 * for the same key at different time stamps and retrieve the key's value
 * at a certain timestamp.
 */


class Node {
    private int timestamp;
    private String value;

    public Node(int timestamp, String value) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

public class TimeMap_981 {
    private final Map<String, List<Node>> timeMap;

    public TimeMap_981() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>())
                .add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!timeMap.containsKey(key)) return "";

        List<Node> nodes = timeMap.get(key);
        int low = 0;
        int high = nodes.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nodes.get(mid).getTimestamp() <= timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high >= 0 ? nodes.get(high).getValue() : "";
    }
}