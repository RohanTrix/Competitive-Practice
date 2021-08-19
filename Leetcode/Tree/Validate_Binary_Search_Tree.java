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
class Validate_Binary_Search_Tree {
    public boolean recur(TreeNode root,long lowerBound,long upperBound)
    {
        boolean left = true;
        boolean right = true;
        if(root.val<=lowerBound || root.val >=upperBound ) return false;
        if(root.left!=null)
        {
             left = recur(root.left,lowerBound, root.val);
        }
        if(root.right!=null)
        {
             right = recur(root.right, root.val, upperBound);
        }
        if(left && right)
            return true;
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return recur(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
        
    }
}