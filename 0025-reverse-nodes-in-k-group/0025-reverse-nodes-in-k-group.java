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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        
        // count the number of nodes
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        
        // if there are k nodes, reverse them
        if (count == k) {
            curr = reverseKGroup(curr, k);
            
            // reverse current k-group
            while (count-- > 0) {
                ListNode temp = head.next;
                head.next = curr;
                curr = head;
                head = temp;
            }
            
            head = curr;
        }
        
        return head;
    }
}