package tree;

/*
 * LeetCode Problem 102: Binary Tree Level Order Traversal
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> response = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                nodes.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            response.add(nodes);
        }

        return response;
    }
}
