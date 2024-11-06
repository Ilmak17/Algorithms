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
    private final Map<String, List<Node>> map;

    public TimeMap_981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Node(timestamp, value));
    }

    public String get(String key, int timestamp) {
        List<Node> nodes = map.getOrDefault(key, new ArrayList<>());
        int left = 0;
        int right = nodes.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nodes.get(mid).getTimestamp() <= timestamp) {
                result = nodes.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}