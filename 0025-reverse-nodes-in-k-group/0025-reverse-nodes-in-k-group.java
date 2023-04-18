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
    if (head == null || k == 1) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    while (head != null) {
      ListNode tail = prev;
      for (int i = 0; i < k; i++) {
        tail = tail.next;
        if (tail == null) return dummy.next;
      }
      ListNode nextGroup = tail.next;
      ListNode[] reversedGroup = reverseList(head, tail);
      head = reversedGroup[0];
      tail = reversedGroup[1];
      prev.next = head;
      tail.next = nextGroup;
      prev = tail;
      head = tail.next;
    }
    return dummy.next;
  }
  private ListNode[] reverseList(ListNode head, ListNode tail) {
    ListNode prev = tail.next;
    ListNode curr = head;
    while (prev != tail) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return new ListNode[] {tail, head};
  }
}