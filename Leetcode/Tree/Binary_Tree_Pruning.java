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


class Binary_Tree_Pruning {
    // We return false from a node if no 1 exists iin its subtree. We also detach a child subtree from a
    // node if that child returns false(i.e no 1 in child subtree). So finally, we return true if either
    // of the child subtrees have a 1 OR if the current node's val == 1 
    public boolean dfs(TreeNode root)
    {
        if(root==null) return false; 

        boolean b1 = dfs(root.left);
        if(!b1)root.left=null;
        boolean b2 = dfs(root.right);
        if(!b2)root.right=null;
        return b1||b2 ||root.val==1;
    }
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root)==true?root:null;
    }
}