public class Lowest_Common_Ancestor_of_a_Binary_Tree {
    // REFER : Best explanantion at https://youtu.be/13m9ZCB8gjw
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left!=null && right!=null) return root;
        if(left!=null) return left;
        else if(right!=null) return right;
        return null;
    }
}
