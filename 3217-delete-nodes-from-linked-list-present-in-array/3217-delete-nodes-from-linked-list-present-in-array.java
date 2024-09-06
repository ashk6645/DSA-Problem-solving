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
    public ListNode modifiedList(int[] nums, ListNode head) 
    {
        HashSet<Integer> list = new HashSet<>();
        for(int i : nums)
        {
            list.add(i);
        }
        
        while(head.next != null && list.contains(head.val))
        {
            head = head.next;
        }
        if(head == null)
        {
            return null;
        }
        
        ListNode prev = head;
        ListNode temp = head;
        while(temp != null)
        {
            if(list.contains(temp.val))
            {
                prev.next = temp.next; //skip the node 
            }
            else
            {
                prev = temp; 
            }
            temp = temp.next;  //always move temp variable forward
        }
        return head;
    }
}