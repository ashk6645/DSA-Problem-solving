/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
        {
            return false;
        }
        ListNode turtle = head; //slow
        ListNode hare = head;   //fast
        while(hare != null && hare.next != null)
        {
            turtle = turtle.next;
            hare = hare.next.next;
            if(turtle == hare)
            {
                return true;    //cycle
            }
        }
        return false;  //no cycle
    }
}