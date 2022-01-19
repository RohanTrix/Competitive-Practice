public class Linked_List_Cycle_II
{
    // First find if cycle or not using Floyd cycle detection algorithm.
    // Then if there is a cycle, the slow pointer and the head will be at the same distance from the 
    // node from where cycle starts
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        if(head==null || head.next==null) return null;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow==fast)break;
        }
        if(fast!=slow) return null;
        ListNode temp = head;
        while(temp!=slow)
        {
            temp = temp.next;
            slow = slow.next;
        }
        return slow;
    }
}