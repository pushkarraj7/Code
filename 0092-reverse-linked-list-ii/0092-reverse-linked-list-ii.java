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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevLeft = dummy;
        
        // Move prevLeft to the node just before the start of the reverse portion
        for (int i = 0; i < left - 1; i++) {
            prevLeft = prevLeft.next;
        }
        
        // Initialize pointers for reversal
        ListNode curr = prevLeft.next;
        ListNode prev = null;
        
        // Reverse the sublist from left to right
        for (int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Connect the reversed sublist back to the original list
        prevLeft.next.next = curr;
        prevLeft.next = prev;
        
        return dummy.next;
    }
}