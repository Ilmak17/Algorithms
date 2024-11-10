package tree;

/*
 * LeetCode Problem 572: Subtree of Another Tree
 * Difficulty: Easy
 *
 * Problem Statement:
 * Given the roots of two binary trees root and subRoot,
 *  return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree is a tree that consists of a node in tree and all of this node's descendants.
 *  The  tree could also be considered as a subtree of itself.
 */

public class SubtreeOfAnotherTree_572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSubRoot(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSubRoot(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        return root.val == subRoot.val
                && isSubRoot(root.left, subRoot.left)
                && isSubRoot(root.right, subRoot.right);
    }
}
