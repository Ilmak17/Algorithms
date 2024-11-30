package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, List<Node> _neighbors) {
        this.val = val;
        neighbors = _neighbors;
    }
}
/*
 * LeetCode Problem 133: Clone Graph
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 */

public class CloneGraph_133 {
    private final Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node newNode = new Node(node.val);
        visited.put(node.val, newNode);

        for (Node neighbour : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbour));
        }

        return newNode;
    }
}
