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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode t =  head;
        int count = 0;
        while(t!=null)
        {
            count++;
            t = t.next;                
        }
        t = head;
        int num = 0,sto1 = 0,sto2 = 0;
        while(t!=null)
        {
            num++;
            if(num==k)
                sto1 = t.val;
            if(num==count-k+1)
                sto2 = t.val;
            t=t.next;
        }
        num=0;
        t = head;
        while(t!=null)
        {
            num++;
            if(num==k)
                t.val = sto2;
            if(num==count-k+1)
                t.val = sto1;
            t = t.next;
        }
        return head;
        
    }
}