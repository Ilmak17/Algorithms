package tree;

/*
 * LeetCode Problem 863: All Nodes Distance K in Binary Tree
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, the value of a target node target, and an integer k,
 * return an array of the values of all nodes that have a distance k from the target node.
 * You can return the answer in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKBinaryTree_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parents = buildParents(root);
        List<Integer> result = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(target, 0));
        visited.add(target);

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int dist = pair.getValue();

            if (dist == k) {
                result.add(node.val);
                continue;
            }

            for (TreeNode neighbor : getNeighbors(node, parents)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(new Pair<>(neighbor, dist + 1));
                }
            }
        }

        return result;
    }

    private List<TreeNode> getNeighbors(TreeNode node, Map<TreeNode, TreeNode> parents) {
        List<TreeNode> neighbors = new ArrayList<>();
        if (node.left != null) neighbors.add(node.left);
        if (node.right != null) neighbors.add(node.right);
        if (parents.containsKey(node)) neighbors.add(parents.get(node));

        return neighbors;
    }

    private Map<TreeNode, TreeNode> buildParents(TreeNode root) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                parents.put(node.left, node);
                queue.add(node.left);
            }

            if (node.right != null) {
                parents.put(node.right, node);
                queue.add(node.right);
            }
        }

        return parents;
    }
}
