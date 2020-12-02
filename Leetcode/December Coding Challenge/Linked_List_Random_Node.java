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
import java.util.Random;
public class Linked_List_Random_Node {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    
    Random r = null;
    ListNode top;
    public Solution(ListNode head) {
        top = head;
        r = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode temp = top;
        int currNumNodes = 1;
        int randval = 0;
        while( temp!= null)
        {
            if( r.nextInt(currNumNodes) == 0)
                randval = temp.val;
            temp = temp.next;
            currNumNodes++;
        }
        return randval;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */