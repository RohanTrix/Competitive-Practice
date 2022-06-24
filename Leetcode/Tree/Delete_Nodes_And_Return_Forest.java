public class Delete_Nodes_And_Return_Forest
{
    Set<Integer> delete;
    List<TreeNode> ans;
    // add represents whether this node should be added to ans or not. If the node is a root of a subtree we want to add..
    // only then add=true
    public TreeNode dfs(TreeNode root, boolean add)
    {
        if(root == null)
            return null;
        
        // If current node is removed....then the left and right child will become new roots..hence add=true
        // However..if those root nodes also present in delete...they will not get added to ans, otherwise they will.
        if(delete.contains(root.val))
        {
            dfs(root.left, true);
            dfs(root.right, true);
            return null; // The parent of current node should now have null in its place
        }
        if(add)
            ans.add(root);
        // We have to reassign the left and right tree as it might have become null.
        root.left = dfs(root.left, false);
        root.right = dfs(root.right, false);
        return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        ans = new ArrayList<>();
        delete = new HashSet<>();
        for(int num : to_delete) delete.add(num);
        dfs(root, true);
        return ans;
    }
}