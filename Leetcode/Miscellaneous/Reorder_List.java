/**
 * IDEA : 1) First find mid of the linked list. Split the lists into 2 parts.
 *        2) Since we want to traverse the 2nd half from back, reverse the second part. of the list.
 *        3) Merge the two lists by placing nodes alternatively.
 */
public class Reorder_List {
    public ListNode reverse(ListNode mid)
    {
        ListNode next;
        ListNode prev = null;
        ListNode curr = mid;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head.next == null) return;
        ListNode fast = head, slow = head;
        ListNode prev = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode mid = slow;
        prev.next = null;
        ListNode end = reverse(mid);
        ListNode gen = new ListNode(-1);
        prev = gen;
        ListNode front_next, end_next;
        while(head!=null)
        {
            front_next = head.next;
            end_next = end.next;
            prev.next = head;
            prev = head;
            prev.next = end;
            prev = end;
            head = front_next;
            end = end_next; 
        }
        head = gen.next;
    }
}
