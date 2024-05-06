import java.util.Stack;

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        
       
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        
        int maxVal = Integer.MIN_VALUE;
        ListNode resultList = null;
        
        
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val >= maxVal) {
                maxVal = node.val;
                resultList = new ListNode(node.val, resultList);
            }
        }
        
        return resultList;
    }
}
