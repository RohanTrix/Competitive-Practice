package Leetcode.Tree;

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /*
        IDEA : To convert the LinkedList into the a Balaanced BST....we can think of a divide and conquer 
                approach to divide the linkedlist at a middle node, convert the remaining left part into
                a balanced BST, convert the remaining right part into a balanced BST and make both of these
                the children of the mid node where we partitioned.
 */
class Solution {
    public TreeNode convertToBST(ListNode start, ListNode end)
    {
        if(start == null) return null;
        if(start==end) return new TreeNode(start.val);

        ListNode slow = start;
        ListNode prev = null;
        ListNode fast = start;
        while(fast!=null && fast.next!=null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null)
            prev.next = null;

        TreeNode leftSubTree, rightSubTree;
        leftSubTree = convertToBST(start, prev);
        if(slow != end)
            rightSubTree = convertToBST(slow.next, end);
        else
            rightSubTree = null;
        TreeNode mid = new TreeNode(slow.val);
        mid.left = leftSubTree;
        mid.right = rightSubTree;
        return mid;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode end = head;
        if(head==null) return null;
        while(end.next!=null)
            end = end.next;
        return convertToBST(head, end);
    }
}