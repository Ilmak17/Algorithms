package tree;

/*
 * LeetCode Problem 1485: Clone Binary Tree With Random Pointer
 * Difficulty: Medium
 *
 * Problem Statement:
 * You are given a binary tree where each node has an additional pointer called the random pointer. This random pointer may point to any other node in the tree or could be set to null.
 * Create and return a deep copy of this binary tree.
 * In the input, each node is represented by a pair [val, random_index]:
 * val is an integer that represents the value of the node.
 * random_index is the index of the node (in the input list)
 *  to which the random pointer is pointing, or null if it does not point to any node.
 * The deep copy must replicate both the structure of the tree and the configuration of the random pointers.
 */

import java.util.HashMap;

public class CloneBinaryTreeWithRandomPointer_1485 {
    public TreeNode copyRandomBinaryTree(TreeNode root) {
        if (root == null) return null;

        HashMap<TreeNode, TreeNode> clonedMap = new HashMap<>();

        return cloneNode(root, clonedMap);
    }

    private TreeNode cloneNode(TreeNode node, HashMap<TreeNode, TreeNode> clonedMap) {
        if (node == null) return null;

        if (clonedMap.containsKey(node)) return clonedMap.get(node);

        TreeNode newNode = new TreeNode(node.val);

        clonedMap.put(node, newNode);

        newNode.left = cloneNode(node.left, clonedMap);
        newNode.right = cloneNode(node.right, clonedMap);
        newNode.random = cloneNode(node.random, clonedMap);

        return newNode;
    }
}
