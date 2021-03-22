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
    public void dfs(TreeNode root)
    {
        if(root.left==null && root.right==null)
            return;
        if (root.left!=null)

            dfs(root.left);
        if (root.right!=null)
            dfs(root.right);
        TreeNode node;
        node = root.left;
        root.left = root.right;
        root.right = node;
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        dfs(root);
        return root;
    }
}