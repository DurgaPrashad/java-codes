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
    public TreeNode bstToGst(TreeNode root) {
        
        reverseInOrderTraversal(root, 0);
        return root;
    }

    private int reverseInOrderTraversal(TreeNode node, int sum) {
        if (node == null) {
            return sum;
        }
        
        sum = reverseInOrderTraversal(node.right, sum);
        
        sum += node.val;
        node.val = sum;
        
        
        return reverseInOrderTraversal(node.left, sum);
    }
}
