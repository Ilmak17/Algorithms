package tree;

/*
 * LeetCode Problem 297: Serialize and Deserialize Binary Tree
 * Difficulty: Hard
 *
 * Problem Statement:
 * Serialization is the process of converting a data structure
 * or object into a sequence of bits so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be
 * reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 *  You just need to ensure that a binary tree can be serialized to a string and this string can be
 *  deserialized to the original tree structure.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree_297 {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(root, builder);

        return builder.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#").append(",");
            return;
        }
        builder.append(root.val).append(",");
        serializeHelper(root.left, builder);
        serializeHelper(root.right, builder);
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));

        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Queue<String> nodes) {
        String value = nodes.poll();
        if (value.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = deserializeHelper(nodes);
        root.right = deserializeHelper(nodes);

        return root;
    }
}
