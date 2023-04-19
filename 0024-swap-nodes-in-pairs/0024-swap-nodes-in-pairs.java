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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)  return head;        
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        ListNode newHead = head.next;
        while (current != null && current.next != null) {
            next = current.next;
            current.next = next.next;
            next.next = current;
            
            if (prev != null)
                prev.next = next;
            prev = current;
            current = current.next;
        }        
        return newHead;
    }
}