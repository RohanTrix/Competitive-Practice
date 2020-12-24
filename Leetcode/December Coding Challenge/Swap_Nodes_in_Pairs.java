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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null)
            return head;
        ListNode prev=null;
        ListNode newHead = head.next;
        ListNode t1 = head;
        while(t1!=null && t1.next!=null)
        {
            
            ListNode temp = t1.next;
            t1.next = temp.next;
            temp.next = t1;
            if(prev!=null)
                prev.next=temp;
            prev = t1;
            t1 = t1.next;
        }
        return newHead;
    }
}