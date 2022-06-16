public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    // IDEA : Solve Question "Construct Binary Tree from Inorder and Postorder Traversal"
    // and then come back to this. Both are solved by similar technique with slight change in logic
    int preorder[], inorder[];
    public TreeNode construct(int preLeft, int preRight, int inLeft, int inRight)
    {
        // System.out.println(preLeft+" "+ preRight+" "+inLeft+" "+ inRight);
        if(inLeft> inRight)
            return null;
        
        int root_val = preorder[preLeft];
        TreeNode root = new TreeNode(root_val);
        int inorder_root_pos = -1;
        for(int i = inLeft; i<=inRight; i++)
            if(root_val == inorder[i])
                inorder_root_pos = i;
        
        // Cnt of elements in left Subtree
        int cnt = inorder_root_pos - inLeft;
        int partition = preLeft+cnt;
        root.left = construct(preLeft+1, partition, inLeft, inorder_root_pos-1);
        root.right = construct(partition+1, preRight, inorder_root_pos+1, inRight);
        return root;
        
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = inorder.length;
        return construct(0, n-1, 0, n-1);
    }
}
