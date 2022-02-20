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

/*
    IDEA : We basically want to sum up the values and make into one single node.
           So we keep summing up values until we get a zero...we add the sum as a new node in the
           ans linkedlist and move forward. 
*/
public class Merge_Nodes_in_Between_Zeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        while(curr!=null)
        {
            int s = 0;
            while(curr.val!=0)
            {
                s+=curr.val;
                curr = curr.next;
            }
            tmp.next = new ListNode(s);
            tmp = tmp.next;
            curr = curr.next;
        }
        return ans.next;
    }
}