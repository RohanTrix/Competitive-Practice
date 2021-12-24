public class Balance_a_Binary_Search_Tree
{
    // REFER : Discuss Section
    public List<TreeNode> sorted = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return arrToBST(0,sorted.size()-1);
    }
    public void inOrder(TreeNode root)
    {
        if(root==null) return;
        inOrder(root.left);
        sorted.add(root);
        inOrder(root.right);
    }
    public TreeNode arrToBST(int left, int right)
    {
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode root = sorted.get(mid);
        root.left = arrToBST(left, mid - 1);
        root.right = arrToBST(mid + 1, right);
        return root;
    }
}