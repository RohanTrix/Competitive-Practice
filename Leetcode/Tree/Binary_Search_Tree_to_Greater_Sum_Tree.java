public class Binary_Search_Tree_to_Greater_Sum_Tree
{
    // SAME AS Convert_BST_to_Greater_Tree
    int sum = 0;
    public void dfs(TreeNode root)
    {
        if(root == null) return;
        dfs(root.right);
        sum+=root.val;
        root.val = sum;
        dfs(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }
}