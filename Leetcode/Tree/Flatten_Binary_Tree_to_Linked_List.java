public class Flatten_Binary_Tree_to_Linked_List {
    // REFER NeetCode : https://youtu.be/rKnD7rLT0lI
    public TreeNode flattener(TreeNode root)
    {
        
        if(root == null) return null;
        TreeNode leftStart = root.left;
        TreeNode rightStart = root.right;
        
        TreeNode leftEnd = flattener(leftStart);
        TreeNode rightEnd = flattener(rightStart);
        
        if(leftEnd != null)
        {
            leftEnd.right = rightStart;
            root.right = leftStart;
            root.left = null;
        }
        if(rightEnd!=null) return rightEnd;
        return leftEnd != null?leftEnd:root;
        
    }
    public void flatten(TreeNode root) {
        flattener(root);
    }
}
