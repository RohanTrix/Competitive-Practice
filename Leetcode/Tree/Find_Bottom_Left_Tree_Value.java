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

import java.util.*;
class Find_Bottom_Left_Tree_Value {
    // Idea : Right to left Level Order Traversal
    public int findBottomLeftValue(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)) return root.val;
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode temp = null;
        while(!q.isEmpty())
        {
            temp = q.poll();
            if(temp.right!=null) q.offer(temp.right);
            if(temp.left!=null) q.offer(temp.left);
        }
         return temp.val;
    }
}