package Leetcode.Tree;

public class Sum_Root_to_Leaf_Numbers {
    int sum = 0;
    public void dfs(TreeNode root, int num)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            sum+=(num*10+root.val);
            return;
        }
        dfs(root.left, num*10+root.val);
        dfs(root.right, num*10+root.val);
    }
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }
}
