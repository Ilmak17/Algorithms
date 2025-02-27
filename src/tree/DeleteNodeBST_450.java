package tree;

/*
 * LeetCode Problem 450: Delete Node in a BST
 * Difficulty: Medium
 *
 * Problem Statement:
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */

public class DeleteNodeBST_450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            root.val = getMinVal(root.right);
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }

    private int getMinVal(TreeNode node) {
        int minVal = node.val;

        while (node.left != null) {
            minVal = node.left.val;
            node = node.left;
        }

        return minVal;
    }
}
