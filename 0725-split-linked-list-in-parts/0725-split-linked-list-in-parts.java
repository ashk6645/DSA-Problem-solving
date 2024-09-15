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
    public ListNode[] splitListToParts(ListNode head, int k)
    {
        ListNode[] ans = new ListNode[k];
        int size = 0;
        ListNode current = head;
        while(current != null)
        {
            size++;
            current = current.next;
        }
        int splitSize = size/k;
        int numRemains = size % k;
        current = head;
        ListNode prev = current;
        for(int i=0;i<k;i++)
        {
            ListNode newPart = current;
            int currentSize = splitSize;
            if(numRemains > 0)
            {
                numRemains--;
                currentSize++;
            }
            int j=0;
            while(j<currentSize)
            {
                prev = current;
                current = current.next;
                j++;
            }
            if(prev != null)
            {
                prev.next = null;
            }
            ans[i] = newPart;
        }
        return ans;
        
        
    }
}