/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Plus_One_Linked_List {
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode curr = head;
        while(curr.next!=null)
        {
            s.push(curr);
            curr = curr.next;
        }
        s.push(curr);
        int carry = 1,n_carry = 0;
        while(s.size()!=0)
        {
            ListNode temp = s.pop();
            n_carry = (temp.val + carry) /10;
            temp.val = (temp.val + carry) %10;
            carry = n_carry;
        }
        if(carry==1)
        {
            curr = new ListNode(1);
            curr.next = head;
            head = curr;
        }
        return head;
    }
}