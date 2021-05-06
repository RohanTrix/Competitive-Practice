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
class Solution {
    // REFER :- 
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head;
        ListNode last = null;
        while(fast!=null && fast.next!=null)
        {
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        last.next = null;
        TreeNode newNode = new TreeNode(slow.val);
        newNode.left = sortedListToBST(head);
        newNode.right = sortedListToBST(slow.next);
        return newNode;
    }
}