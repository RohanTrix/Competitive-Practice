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
    public boolean dfs(TreeNode l, TreeNode r)
    {
        if(l==null && r==null) return true;
        if(l==null || r==null) return false;
        if(l.val!=r.val) return false;
        return dfs(l.left, r.right) && dfs(l.right, r.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }
}