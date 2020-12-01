public class Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;
        if(root.left==null && root.right==null)
            return 1;
        int val1 = 1,val2 = 1;
        if(root.left!=null)
            val1 +=  maxDepth(root.left);
        if(root.right!=null)
            val2 += maxDepth(root.right);
        return Math.max(val1,val2);
    }
}
