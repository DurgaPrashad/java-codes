/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        // Helper method to recursively remove target leaf nodes
        return removeLeafHelper(root, target);
    }

    private TreeNode removeLeafHelper(TreeNode node, int target) {
        if (node == null) {
            return null;
        }

        // Post-order traversal: process left and right children first
        node.left = removeLeafHelper(node.left, target);
        node.right = removeLeafHelper(node.right, target);

        // If the current node is a leaf and its value equals the target, remove it (return null)
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }

        return node;
    }
}
