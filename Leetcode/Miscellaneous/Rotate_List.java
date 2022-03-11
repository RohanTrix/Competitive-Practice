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

// Rotate by dividing the list into two halves and reversing
// their occurences.
class Rotate_List {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next==null) return head;
        int n = 0;
        ListNode tmp = head;
        ListNode prev = null; 
        while(tmp!=null){prev = tmp;tmp = tmp.next; n++;}
        k%=n;
        
        tmp = head; prev.next = head;
        prev = null;
        for(int i = 0; i<(n-k); i++)
        {
            prev = tmp;
            tmp = tmp.next;
        }
        prev.next = null;
        return tmp;
    }
}

 // K times rotate by rotating once for k times
class Solution1 {
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