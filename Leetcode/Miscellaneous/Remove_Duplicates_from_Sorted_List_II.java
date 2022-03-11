package Leetcode.Miscellaneous;

/*
    IDEA : We need to keep 2 variables prev and curr. Whenever we have curr and curr.next matching, 
           then we should remove all such same valued currs. Finally on reaching a node where curr
           does not match old value, we can connect previous to this new curr. If the curr and curr.next
           didnt match, we can more both prev and curr frwrd by one.

           The first prev block is a extra block gen(as in the genesis block) which is used to denote 
           after which the final answer has to be returned.
*/
public class Remove_Duplicates_from_Sorted_List_II {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode gen = new ListNode(101), curr = head;
        gen.next = head;
        ListNode prev = gen;
        while(curr!=null && curr.next!=null)
        {
           
            if(curr.val == curr.next.val)
            {
                int val = curr.val;
                while(curr !=null && curr.val==val)
                {
                    curr = curr.next;
                }
                prev.next = curr;
            }
            else
            {
                prev = curr;
                curr = curr.next;
            }
            
        }
        return gen.next;
    }
}
