/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Intersection_of_Two_Linked_Lists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode temp = headA;
        int n = 0;
        while(temp!=null)
        {
            n++;
            temp = temp.next;
        }
        temp = headB;
        int m = 0;
        while(temp!=null)
        {
            m++;
            temp = temp.next;
        }
        if(n>m)
        {
            for(int i=0;i<n-m;i++)
                headA = headA.next;
        }
        else
        {
            for(int i = 0;i<m-n;i++)
                headB = headB.next;
            
        }
        while(headA!=headB)
        {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}