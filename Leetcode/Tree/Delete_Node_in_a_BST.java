public class Delete_Node_in_a_BST {
    // REFER : https://youtu.be/j6IHk2cH58I
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val < key) root.right = deleteNode(root.right, key);
        else if(root.val > key) root.left = deleteNode(root.left, key);
        else
        {
            // Leaf Node
            if(root.left==null && root.right==null) return null;

            // Single Child
            if(root.right==null || root.left==null)
            {
                if(root.left!=null)return root.left;
                return root.right;
            }

            // Both Children
            TreeNode tmp = root.right;
            while(tmp.left!=null) tmp = tmp.left;
            root.val = tmp.val;
            root.right = deleteNode(root.right, tmp.val); // This call will delete the temp value like a node
                                                          // with a single child
        
        }
        return root;
    }
}
