package linkedlist;

/*
 * LeetCode Problem 21: Merge Two Sorted Lists
 * Difficulty: Easy
 *
 * Problem Statement:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together
 * the nodes of the first two lists.
 * Return the head of the merged linked list.
 */

import java.util.HashMap;
import java.util.Map;

class CacheNode {
    int key;
    int val;
    CacheNode next;
    CacheNode prev;

    public CacheNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache_146 {

    private final Map<Integer, CacheNode> cache;
    private final int capacity;
    private final CacheNode right;
    private final CacheNode left;

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.right = new CacheNode(0, 0);
        this.left = new CacheNode(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            CacheNode cacheNode = cache.get(key);
            remove(cacheNode);
            insert(cacheNode);

            return cacheNode.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
            cache.remove(key);
        }
        CacheNode newCacheNode = new CacheNode(key, value);
        cache.put(key, newCacheNode);
        insert(newCacheNode);

        if (cache.size() > capacity) {
            CacheNode lastCacheNode = left.next;
            remove(lastCacheNode);
            cache.remove(lastCacheNode.key);
        }
    }

    private void insert(CacheNode cacheNode) {
        CacheNode prev = right.prev;
        prev.next = cacheNode;
        cacheNode.prev = prev;
        right.prev = cacheNode;
        cacheNode.next = right;
    }

    private void remove(CacheNode cacheNode) {
        CacheNode prev = cacheNode.prev;
        CacheNode next = cacheNode.next;
        prev.next = next;
        next.prev = prev;
    }
}
