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
    class Path_Sum {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if(root==null) return false;
            if(root.left==null && root.right==null && targetSum==root.val) return true;
            boolean a1=false, a2 = false;
            if(root.left!=null) a1 = hasPathSum(root.left, targetSum-root.val);
            if(root.right!=null) a2 = hasPathSum(root.right, targetSum-root.val);
            return a1 || a2;


        }
    }