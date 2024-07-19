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
    public ListNode removeZeroSumSublists(ListNode head) 
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        ListNode current = dummy;
        
       
        while (current != null)
        {
            prefixSum += current.val;
            prefixSumMap.put(prefixSum, current);
            current = current.next;
        }
        
        
        prefixSum = 0;
        current = dummy;
        
        
        while (current != null)
        {
            prefixSum += current.val;
            current.next = prefixSumMap.get(prefixSum).next;
            current = current.next;
        }
        
        return dummy.next;
        
    }
}