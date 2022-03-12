public class Copy_List_with_Random_Pointer
{
    // REFER : https://leetcode.com/problems/copy-list-with-random-pointer/discuss/1059181/C%2B%2B-or-Three-Pass-or-O(n)-0ms-Beats-100-or-Explanation-(with-example)
    public void viewList(Node head)
    {
        
        while(head!=null)
        {
            System.out.print(head.val+"->");
            head = head.next;
        }
    }
    public Node copyRandomList(Node head) {
        // First Pass
        if(head == null) return head;
        Node tmp = head;
        while(tmp!=null)
        {
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = tmp.next.next;
        }
        // First Pass Ended
        //viewList(head);
        // Second Pass
        tmp = head;
        while(tmp!=null)
        {
            if(tmp.random!=null)
                tmp.next.random = tmp.random.next;
            tmp = tmp.next.next;
        }
        // Second Pass Ended
        
        // Third Pass
        Node gen = new Node(0);
        tmp = gen;
        
        while(head!=null)
        {
            tmp.next = head.next;
            tmp = tmp.next;
            
            head.next=head.next.next;
            head = head.next;
        }
        // Third Pass Ended
        return gen.next;
    }
}