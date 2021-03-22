package Leetcode.Tree;

public class Range_Sum_of_BST {
    int sum;
    public void dfs(TreeNode root, int low, int high)
    {
        if(root==null) return;
        if(root.val>=low && root.val<=high) sum+=root.val;
        dfs(root.left, low, high);
        dfs(root.right, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;
    }
}
