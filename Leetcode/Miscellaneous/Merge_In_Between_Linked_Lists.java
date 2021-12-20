public class Merge_In_Between_Linked_Lists
{
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode tmp1 = list1, tmp2 = list1;
        int n = 0;
        ListNode tail = list2;
        while(tail.next!=null) tail = tail.next;
        while(n++!=(a-1))
            tmp1 = tmp1.next;
        n = 0;
        while(n++!=(b+1))
            tmp2 = tmp2.next;
        tmp1.next = list2;
        tail.next = tmp2;
        
        return list1;
        
    }
}