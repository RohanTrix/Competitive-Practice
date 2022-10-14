public class Delete_the_Middle_Node_of_a_Linked_List {
    public ListNode deleteMiddle(ListNode head) {
        ListNode gen = new ListNode();
        gen.next = head;
        ListNode prev = gen;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return gen.next;
    }
}
