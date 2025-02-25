package tree;

/*
 * LeetCode Problem 94. Binary Tree Inorder Traversal
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);

        return list;
    }

    private void helper(List<Integer> integerList, TreeNode root) {
        if (root == null) return;
        helper(integerList, root.left);
        integerList.add(root.val);
        helper(integerList, root.right);
    }
}

