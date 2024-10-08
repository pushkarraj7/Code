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


// class Solution {
//     public ListNode[] splitListToParts(ListNode head, int k) {
//         int length = 0;
//         ListNode current = head;

//         // Find the length of the linked list
//         while (current != null) {
//             length++;
//             current = current.next;
//         }
//         // Calculate the size of each part and the number of remaining elements
//         int partSize = length / k;
//         int remaining = length % k;

//         current = head;
//         ListNode[] result = new ListNode[k];
//         // Traverse the linked list and split it into parts
//         for (int i = 0; i < k && current != null; i++) {
//             result[i] = current;
//             int partLength = partSize + (i < remaining ? 1 : 0); // Adjust part size for remaining elements
//             for (int j = 0; j < partLength - 1; j++) {
//                 current = current.next;
//             }
//             ListNode next = current.next;
//             current.next = null;
//             current = next;
//         }         
//         return result;
//     }
// }


class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        ListNode res[] = new ListNode[k];
        temp = head;
        int avg = size/k;
        int extra = size%k;
        for(int i = 0; i < k; i++){
            if(temp == null) break;
            ListNode curHead = temp;
            ListNode prev = null;
            int len = 0;
            while(temp!=null && len < avg){
                prev = temp;
                temp = temp.next;
                len++;
            }
            if(extra > 0){
                prev = temp;
                temp = temp.next;
                extra--;
            }
            prev.next = null;
            res[i] = curHead;
        }
        return res;
    }
}