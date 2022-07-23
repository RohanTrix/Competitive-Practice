public class Reverse_Linked_List_II
{
    public ListNode[] reverse(ListNode head)
    {
        // Returns first and last node of the LinkedList
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{prev, head};
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode gen = new ListNode(-1, head);
        ListNode l = head, r = head;
        ListNode prev = gen;
        while(left>1){left--; l = l.next;prev = prev.next;}
        while(right>1){right--; r = r.next; };
        ListNode last = r.next;
        r.next = null;
        ListNode rev[] = reverse(l);
        prev.next = rev[0];
        rev[1].next = last;
        return gen.next;
    }
}