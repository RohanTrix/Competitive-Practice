/*
    DISCLAIMER: Others may have a shorter solution but this is more intuitive and simpler to come up with in my opinion
                Solved in One go :)
*/
public class Reverse_Nodes_in_k_Group
{
    // Function to simply reverse a linked list
    public ListNode reverseList(ListNode head) {
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
        return prev;
    }
    // Function to get kth node starting from current head
    public ListNode getKthNode(ListNode head, int k)
    {
        ListNode tmp = head;
        for(int i =0; i<k-1; i++)
        {
            if(tmp.next == null)
                { return head;}
            tmp = tmp.next;
        }
        return tmp;
    }
    // Count no. of nodes in current remaining list
    public int count(ListNode head)
    {
        ListNode tmp = head;
        int n = 0;
        while(tmp!=null)
        {
            n++;
            tmp = tmp.next;
        }
        return n;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode genesis = new ListNode(-1); // Next of this node will be contain our answer
        
        // When we have to reverse k nodes, after the reversal, it should properly connect to the previously processed list and
        // the next list to be processed.

        // This means we should have a pointer to the last node of previous processed list (prevList) and the first node to the
        // list which needs to be processed next (nextList).

        // Moreover, we only do processing if nextList has >=k nodes. We use count method to count nodes.

        ListNode prevList = genesis;
        ListNode nextList = null;
        ListNode start = head;
        while(count(start)>=k)
        {
            ListNode endNode = getKthNode(start,k);
            nextList = endNode.next;
            endNode.next = null;
            ListNode newCurrHead = reverseList(start);
            prevList.next = newCurrHead;
            start.next = nextList;
            prevList = start;
            start = nextList;
        }
        return genesis.next;
    }
}