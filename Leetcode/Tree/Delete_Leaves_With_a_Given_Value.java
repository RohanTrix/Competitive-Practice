/*
        IDEA : CLASSIC POST ORDER TRAVERSAL. We know we need to process both children first
               Because only then we would know whether or not the current node has become a 
               leaf node or not. 

*/

public class Delete_Leaves_With_a_Given_Value {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        
        if(root == null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        
        if(root.left == null && root.right==null && root.val == target)
            return null;
        return root;
    }
}
