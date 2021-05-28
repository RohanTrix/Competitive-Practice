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
        
        ListNode slowptr = head;
        ListNode fastptr = head;
        if(head==null || head.next==null) return false;
        do
        {
            slowptr = slowptr.next;
            if(slowptr==null) return false;
            fastptr = fastptr.next.next;
            if(fastptr == null || fastptr.next==null) return false;
        }while(slowptr!=fastptr);
        return true;
        
    }
}