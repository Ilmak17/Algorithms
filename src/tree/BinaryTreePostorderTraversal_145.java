
package tree;

/*
 * LeetCode Problem 145. Binary Tree Postorder Traversal
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);

        return list;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;
        helper(list, root.left);
        helper(list, root.right);
        list.add(root.val);
    }
}

