import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int currDepth = 1;
        
        while (currDepth < depth - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            currDepth++;
        }
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode leftChild = new TreeNode(val);
            TreeNode rightChild = new TreeNode(val);
            leftChild.left = node.left;
            rightChild.right = node.right;
            node.left = leftChild;
            node.right = rightChild;
        }
        
        return root;
    }
}
