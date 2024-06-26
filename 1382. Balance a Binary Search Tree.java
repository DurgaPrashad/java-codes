import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return buildBalancedBST(sortedList, 0, sortedList.size() - 1);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sortedList);
        sortedList.add(node.val);
        inOrderTraversal(node.right, sortedList);
    }

    private TreeNode buildBalancedBST(List<Integer> sortedList, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = buildBalancedBST(sortedList, start, mid - 1);
        node.right = buildBalancedBST(sortedList, mid + 1, end);
        return node;
    }
}
