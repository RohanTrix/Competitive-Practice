
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode ans = head;
        int carry = 0;
        while(l1!=null || l2!=null)
        {
            ListNode t = new ListNode();
            head.next = t;
            t.next = null;
            head = t;
            if(l1!=null && l2!=null)
            {
                head.val = (l1.val+l2.val+ carry)%10 ;
                carry = (l1.val+l2.val+ carry)/10;
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1==null && l2!=null)
            {
                head.val = (l2.val + carry)%10;
                carry = (l2.val+carry)/10;
                l2 = l2.next;
            }
            else if(l1!=null && l2==null)
            {
                head.val = (l1.val + carry)%10;
                carry = (l1.val + carry)/10;
                l1 = l1.next;
            }

        }
        if(carry!=0){
            head.next = new ListNode();
            head.next.val = 1;
            head.next.next = null;
        }
        
        return ans.next;
    }
}