/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode podd = odd, peven = even;
        ListNode curr = head;
        int cnt = 1;
        while (curr != null) {
            ListNode next = curr.next;
            if (cnt % 2 == 0) {
                peven.next = curr;
                peven = peven.next;
            } 
            else {
                podd.next = curr;
                podd = podd.next;
            }
            cnt++;
            curr.next = null;
            curr = next;
        }
        podd.next = even.next;
        return odd.next;
    }
}