
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public void dfs(TreeNode root, int v, int d, int curr_d)
    {
        if(curr_d == d-1)
        {
            TreeNode t1 = new TreeNode();
            TreeNode t2 = new TreeNode();
            t1.val = v;
            t2.val = v;
            TreeNode temp;
            temp = root.left;
            root.left = t1;
            t1.left = temp;
            temp = root.right;
            root.right = t2;
            t2.right = temp;
            return;
        }
        if( root.left!=null) dfs(root.left, v, d, curr_d+1); // Left subtree
        if (root.right!=null) dfs(root.right, v, d, curr_d+1); // right subtree
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d==1)
        {
            TreeNode t = new TreeNode();
            t.val = v;
            t.left = root;
            return t;
        }
        dfs(root, v, d, 1);
        return root;
    }
}