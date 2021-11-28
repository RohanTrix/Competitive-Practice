public class Convert_BST_to_Greater_Tree
{
    int currSum = 0;
    public void dfs(TreeNode root)
    {
        if(root==null) return;
        dfs(root.right);
        int val = root.val;
        root.val+=currSum;
        currSum+=val;
        dfs(root.left);
        
    }
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
}