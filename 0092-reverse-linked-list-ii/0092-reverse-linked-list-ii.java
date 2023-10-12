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
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        int idx = 1;

        // Move to the node before the reverse portion
        while (idx < left) {
            prev = prev.next;
            idx++;
        }

        // Reverse the portion from left to right
        ListNode current = prev.next;
        ListNode next;

        while (idx < right) {
            next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
            idx++;
        }

        return dummy.next;
    }
}
