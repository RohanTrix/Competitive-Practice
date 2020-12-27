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
    public ListNode rotateRight(ListNode node, int k) {
        if(k==0) return node;
        if(node==null) return node;
        ListNode ptr = node;
        ListNode last = null;
        int cnt =0;
        while(ptr!=null)
        {
            last  =ptr;
            ptr = ptr.next;
            cnt++;
        }
        k  =k%cnt;
        if(k==cnt || k==0) return node;
        ptr = node;
        for(int i=1;i<=cnt-k-1;i++)
        {
            ptr = ptr.next;
        }
        ListNode start = ptr.next;
        ptr.next = null;
        last.next = node;
        return start;
    }
}