
package tree;

/*
 * LeetCode Problem 144. Binary Tree Preorder Traversal
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);

        return list;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        helper(list, root.left);
        helper(list, root.right);
    }
}

