package tree;

/*
 * LeetCode Problem 449: Serialize and Deserialize BST
 * Difficulty: Medium
 *
 * Problem Statement:
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You need to ensure that a binary search tree can be serialized to a string, and
 * this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBST_449 {
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
