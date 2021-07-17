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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int cnt = 0;
        while(temp!=null)
        {
            cnt++;
            temp = temp.next;
        }
        cnt = cnt-n+1; //nth node from behind is cnt'th node from front
        temp = head;
        if(cnt==1) return head.next;
        ListNode prev = null;
        while(temp!=null)
        {
            cnt--;
            if(cnt==0)
            {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }
}