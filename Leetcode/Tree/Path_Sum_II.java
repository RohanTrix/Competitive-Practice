package Leetcode.Tree;

import java.util.*;

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
class Path_Sum_II {
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(TreeNode root, int T, ArrayList<Integer> curr)
    {
        if(root.left==null && root.right==null)
        {
            if(T-root.val==0)
            {
                curr.add(root.val);
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        curr.add(root.val);
        if(root.left !=null)
        dfs(root.left, T - root.val, new ArrayList<Integer>(curr));
        if(root.right!=null)
        dfs(root.right, T - root.val, new ArrayList<Integer>(curr));
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        dfs(root, targetSum, new ArrayList<Integer>());
        return ans;
    }
}