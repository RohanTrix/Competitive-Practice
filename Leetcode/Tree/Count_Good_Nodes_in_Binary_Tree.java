public class Count_Good_Nodes_in_Binary_Tree {
    // Send the running max to dfs. If max before coming to curr node is more than
    // the node's val, then dont add it to answer. From current root, return
    // left subtrees good nodes + right subtree's good nodes + 0/1 depending on current node being a 
    // good node 
    public int dfs(TreeNode root, int maxi)
    {
        if(root==null) return 0;
        return (maxi>root.val?0:1) + dfs(root.left, Math.max(maxi, root.val)) + dfs(root.right, Math.max(maxi, root.val));
    }
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }
}
