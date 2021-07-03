package Leetcode.Tree;

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
class Kth_Smallest_Element_in_a_BST {
    int val = 0;
    int f = -1;
    public void dfs(TreeNode curr, int k)
    {
        if(curr==null) return;
        dfs(curr.left, k);
        val++;
        if(val==k) f = curr.val;
        dfs(curr.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return f;
    }
}