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
class Solution1 { // Multiple Passes
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
class Solution { // One pass
    // Think of a 2 pointer/ fixed sliding window of size n.
    // Since the front pointer of the fixed window will reach null first, the back pointer will point to nth node from end at that time.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode gen = new ListNode(-1, head);
        ListNode front = head;
        ListNode back = head;
        ListNode prev = gen;
        while(n>0) // keep front pointer forward by n nodes
        {
            front = front.next;
            n--;
        }
        
        while(front!=null) The bacl
        {
            front = front.next;
            prev = prev.next;
            back = back.next;
        }
        prev.next = back.next;
        return gen.next;
    }
}