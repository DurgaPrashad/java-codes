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
    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftExcess = dfs(node.left);
        int rightExcess = dfs(node.right);

        int totalExcess = node.val + leftExcess + rightExcess - 1;

        moves += Math.abs(leftExcess) + Math.abs(rightExcess);

        return totalExcess;
    }
}
