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
class Solution
{
    public ListNode swapPairs(ListNode head) 
    {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;

    while (prev.next != null && prev.next.next != null) 
    {
        ListNode current = prev.next;
        ListNode next = current.next;

        // Swap nodes
        prev.next = next;
        current.next = next.next;
        next.next = current;

        // Move to the next pair of nodes
        prev = current;
    }
         return dummy.next;

        
    }
}