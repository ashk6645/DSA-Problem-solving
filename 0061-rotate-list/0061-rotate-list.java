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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head == null || head.next == null || k==0)
        {
            return head;
        }
        int length = 1;
        ListNode tail = head;
        while(tail.next != null)
        {
            length++;
            tail = tail.next;
        }
        k = k%length;
        if(k==0)
        {
            return head;
        }
        ListNode newTail = head;
        for (int i = 1; i < length - k; i++) {
            newTail = newTail.next;
        }

        // Update pointers to rotate the list
        ListNode newHead = newTail.next;
        newTail.next = null;
        tail.next = head;

        return newHead;
        
        
    }
}