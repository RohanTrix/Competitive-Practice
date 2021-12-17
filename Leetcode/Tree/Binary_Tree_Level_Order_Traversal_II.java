public class Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null)
            return res;
        ArrayList<Integer> curr = new ArrayList<>();
        
        q.offer(root);
        q.offer(null);
        
        while(!q.isEmpty())
        {
            TreeNode tmp = q.poll();
            if(tmp!=null)
            {
                curr.add(tmp.val);
                if(tmp.left!=null)q.offer(tmp.left);
                if(tmp.right!=null)q.offer(tmp.right);
            }
            else
            {
                res.add(0,new ArrayList<>(curr));
                curr.clear();
                if(!q.isEmpty())q.add(null);
            }
            
        }
        return res;
    }
}
