package Leetcode.Tree;

public class Sum_of_Nodes_with_Even_Valued_Grandparent {
    static int count;
    public void DFS(TreeNode root, TreeNode p, TreeNode gp)
    {
        if(root==null) return;
        if(gp!=null && gp.val%2==0)
        {
            count+=root.val;
        }
        DFS(root.left, root, p);
        DFS(root.right, root ,p);
        
        
    }
    public int sumEvenGrandparent(TreeNode root) {
        count = 0;
        DFS(root, null, null);
        return count;
    }
}
