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



 /* IDEA:
    Send a mini and maxi variable downwards in the tree. Whenever we reach a particular node in the
    tree, the mini and maxi (after the updation step) will denote the maximum and minimum values we
    seen uptil now in the tree including this node. We then send the updated mini and maxi to the 
    left and right subtree and then after recursion is over, we update global variable result
    as MAX(res, maxi - mini).
    
    Insights:
            When we reach a leaf node, we will have the best answer for that branch.
 */

public class Maximum_Difference_Between_Node_and_Ancestor {
    int res = 0;
    public void dfs(TreeNode root, int mini, int maxi)
    {
        if(root==null) return;
        mini = Math.min(root.val, mini);
        maxi = Math.max(root.val, maxi);
        dfs(root.left, mini, maxi);
        dfs(root.right, mini, maxi);
        res = Math.max(res, maxi - mini);
        
        
    }
    public int maxAncestorDiff(TreeNode root) {
        dfs(root, root.val, root.val);
        return res;
    }
}
