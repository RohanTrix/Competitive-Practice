public class Recover_Binary_Search_Tree {
    // REFER : https://youtu.be/2uPKWpMHmZA
    TreeNode first, second;
    TreeNode prev;
    public void inorder(TreeNode root)
    {
        if(root == null) return;
        inorder(root.left);
        if(first == null && prev.val > root.val)
            first = prev;
        if(first!=null && prev.val > root.val)
            second = root;
        prev = root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = null; second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}
