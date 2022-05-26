package Leetcode.Miscellaneous;

/**
 * IDEA : genLow represents genesis of LinkedList in which all nodes with val<x
 *        genHigh represents genesis of LinkedList in which all nodes with val>=x
 * 
 *        Basic idea is to traverse LL with a tmp node, save reference to the next node to current node
 *        and then attach to one of the genesis LL's based on val. The curr last node at any time 
 *        in the 2 LL's are given tmpLow and tmpHigh.
 * 
 *        Finally when the process is over, tmpLow is the last node with val<x. Attach next of this to the genHigh's next.
 *        Finally return genLow which is the final concatenated list
 */


public class Partition_List {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode genLow = new ListNode(-1);
        ListNode genHigh = new ListNode(-1);
        ListNode tmpLow = genLow, tmpHigh = genHigh;
        ListNode tmp = head;
        while(tmp!=null)
        {
            ListNode next = tmp.next;
            tmp.next = null;
            if(tmp.val<x)
            {
                tmpLow.next = tmp;
                tmpLow = tmp;
            }
            else
            {
                tmpHigh.next = tmp;
                tmpHigh = tmp;
            }
            tmp = next;
        }
        tmpLow.next = genHigh.next;
        return genLow.next;
    }
}
