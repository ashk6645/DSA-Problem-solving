/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
if(headA == null || headB == null )
{
return null;
}
int lengthA = getLength(headA);
int lengthB = getLength(headB);
   ListNode currentA = headA;
        ListNode currentB = headB;

while(lengthA > lengthB)
{
currentA = currentA.next;
lengthA--;
}

while(lengthB > lengthA)
{
currentB = currentB.next;
lengthB--;
}
while(currentA != currentB)
{
currentA = currentA.next;
currentB = currentB.next;
}
return currentA;

        
    }
private int getLength(ListNode head)
{
int length = 0;
ListNode current = head;

while(current!=null)
{
length++;
current = current.next;
}
return length;

}
}