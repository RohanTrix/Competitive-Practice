
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
    public ListNode reverseList(ListNode head) {
        ListNode q = null, r = null;
        while(head!=null)
        {
            r = q;
            q = head;
            head = head.next;
            q.next = r;
        }
        return q;
        
    }
}