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
    public ListNode insertionSortList(ListNode head) {
        // First attach a extra starting node to front of list
        
        ListNode start = new ListNode();
        start.next = head;
        
        // Declare previous, curr, after
        
        ListNode prev = start;
        ListNode curr = head;
        ListNode after = head.next;
        while(curr!=null)
        {
            // These two will iterate uptil curr everytime, simulating insertion sort
            ListNode tmpafter = start.next;
            ListNode tmpprev = start;
            
            // variable to check if position of curr has changed
            boolean f = false;
            
            //Loop until the iterating pointer is behind current
            while(tmpafter!=curr)
            {
                if(tmpafter.val>=curr.val)
                {
                    prev.next = after;
                    curr.next = tmpafter;
                    tmpprev.next = curr;
                    f = true;
                    curr = after;
                    if(curr==null)return start.next;
                    after = after.next;
                    
                    break;
                }
                tmpprev = tmpafter;
                tmpafter = tmpafter.next;
            }
            if(!f)
                {
                    prev = curr;
                    curr = after;
                    if(curr==null)return start.next;
                    after = after.next;
                }
           }
        return start.next;
        }
}