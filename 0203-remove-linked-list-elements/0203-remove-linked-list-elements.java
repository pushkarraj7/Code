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
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null && head.val==val)
            head=head.next;
        ListNode curr_node=head;
        while(curr_node!=null && curr_node.next!=null){
            if(curr_node.next.val==val)
                curr_node.next=curr_node.next.next;
            else
                curr_node=curr_node.next;
        }
        return head;
    }
}