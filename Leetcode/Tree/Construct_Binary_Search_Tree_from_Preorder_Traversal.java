/**
 *      IDEA : We know that in preOrder traversal, the root is printed first,
 *             then left subtree and then right subtree.
 *             So if we consider our boundaries of the given array as preLeft and preRight,
 *             we know that node at preLeft should be the current root. Next...since this a BST, we know that
 *             all nodes in left subtree will LESS THAN all nodes in right subtree. So we basically find partition point
 *             in the preorder[preLef+1...preRight]... before which all nodes are less than root_val and after which all are
 *             more than root_val.
 *             
 *             Corner Case : When partition = -1, means no left subtree is present. So Math.max(preLeft+1, partition+1)
 *                           handles the starting pos of the right subtree for both cases.
 * 
 */

public class Construct_Binary_Search_Tree_from_Preorder_Traversal {
    int preorder[];
    public TreeNode construct(int preLeft, int preRight)
    {
        if(preLeft> preRight)
            return null;

        int root_val = preorder[preLeft];
        TreeNode root = new TreeNode(root_val);

        int partition = -1;
        for(int i = preLeft+1; i<=preRight; i++)
            if(preorder[i]<root_val)
                partition = i;
        
        if(partition == -1)
            root.left = null;
        else
            root.left = construct(preLeft+1, partition);
        root.right = construct(Math.max(preLeft+1,partition+1), preRight);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        this.preorder = preorder;
        int n = preorder.length;
        return construct(0, n-1);
    }
}
