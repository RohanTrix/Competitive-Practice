package Leetcode.Tree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // We traverse with any one tree...and just keep a check if it lands on same node as original...if it does, we return it.
        TreeNode t1 = null, t2 = null; 
        if(original==target) return cloned;
        if(original.left!=null) t1 = getTargetCopy(original.left, cloned.left, target);
        if(original.right!=null) t2 = getTargetCopy(original.right, cloned.right, target);
        return (t1==null)? t2: t1;
    }
}
