package tree;

/*
 * LeetCode Problem 199: Binary Tree Right Side View
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 *  return the values of the nodes you can see ordered from top to bottom.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            TreeNode lastNode = null;
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                lastNode = node;
                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }
            }
            list.add(lastNode.val);
        }

        return list;
    }
}
