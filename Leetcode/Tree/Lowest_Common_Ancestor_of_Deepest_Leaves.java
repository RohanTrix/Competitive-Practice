/**
 *      IDEA : We find the deepest level nodes using BFS.
 *             Finally, we nest them inside lca queries since LCA(all nodes) = LCA(node1, LCA(node2, LCA(....)))
 */

public class Lowest_Common_Ancestor_of_Deepest_Leaves
{
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = LCA(root.left, p,q);
        TreeNode right = LCA(root.right, p,q);
        if(left ==null) return right;
        else if(right == null) return left;
        return root;
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> lastLevel = new ArrayList<>();
        lastLevel.add(root);
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                TreeNode tmp = q.poll();
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
            if(!q.isEmpty())
            {
                lastLevel.clear();
                lastLevel = new ArrayList<>(q);
            }
        }
        TreeNode lca = lastLevel.get(0);
        for(TreeNode node : lastLevel)
            lca = LCA(root, lca, node);
        return lca;
    }
}