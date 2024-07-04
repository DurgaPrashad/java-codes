/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
       
        ListNode current = head.next;
        ListNode newHead = new ListNode(0); 
        ListNode newCurrent = newHead;
        
        int sum = 0;
        
        while (current != null) {
            if (current.val == 0) {
             
                newCurrent.next = new ListNode(sum);
                newCurrent = newCurrent.next;
                sum = 0;  // Reset sum for the next segment
            } else {
                sum += current.val;
            }
            current = current.next;
        }
        
        return newHead.next;  
    }
}
