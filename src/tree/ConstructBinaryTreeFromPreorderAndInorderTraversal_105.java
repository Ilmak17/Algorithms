package tree;

/*
 * LeetCode Problem 105: Construct Binary Tree from Preorder and Inorder Traversal
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given two integer arrays preorder and inorder
 * where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree,
 * construct and return the binary tree.
 */

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int idx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                idx = i;
                break;
            }
        }

        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, idx + 1),
                Arrays.copyOfRange(inorder, 0, idx));
        root.right = buildTree(
                Arrays.copyOfRange(preorder, idx + 1, preorder.length),
                Arrays.copyOfRange(inorder, idx + 1, inorder.length));

        return root;
    }

}
