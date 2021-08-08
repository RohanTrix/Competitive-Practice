package Leetcode.Miscellaneous;
import java.util.*;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 


public class Merge_k_Sorted_Lists {
     // REFER: https://youtu.be/q5a5OiGbT6Q
    
     public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0) return null;
        
        ArrayList<ListNode> arrlists = new ArrayList<ListNode>();
        
        
        for( int i = 0 ; i<lists.length; i++)
            arrlists.add(lists[i]);
        
        
        while(arrlists.size() > 1)
        {
            ArrayList<ListNode> mergeLists = new ArrayList<>();
            
            for(int i=0; i<arrlists.size();i+=2)
            {
                ListNode l1 = arrlists.get(i);
                ListNode l2 = (i+1 < arrlists.size())?arrlists.get(i+1):null;
                mergeLists.add(mergeTwoLists(l1,l2));
            }
            System.out.println(mergeLists);
            arrlists = new ArrayList<>(mergeLists);
            
        }
        return arrlists.get(0);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        ListNode temp = new ListNode();
        ListNode tail = temp;
        
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                tail.next = l1;
                l1 = l1.next;
            }
            else
            {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        
        if(l1==null)
            tail.next = l2;
        else
            tail.next = l1;
        return temp.next;
    }
}
