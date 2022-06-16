public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {
    // REFER for Explanation only : https://youtu.be/0r_cx1c8Z1A
    int postorder[], inorder[];
    public TreeNode construct(int postLeft, int postRight, int inLeft, int inRight)
    {
        if(inLeft> inRight)
            return null;
        
        int root_val = postorder[postRight];
        TreeNode root = new TreeNode(root_val);
        int inorder_root_pos = -1;
        for(int i = inLeft; i<=inRight; i++)
            if(root_val == inorder[i])
                inorder_root_pos = i;
        
        // Cnt of elements in right Subtree
        int cnt = inRight-inorder_root_pos;
        int partition = postRight-cnt-1;
        root.left = construct(postLeft, partition, inLeft, inorder_root_pos-1);
        root.right = construct(partition+1, postRight-1, inorder_root_pos+1, inRight);
        return root;
        
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        int n = inorder.length;
        return construct(0, n-1, 0, n-1);
    }
}
