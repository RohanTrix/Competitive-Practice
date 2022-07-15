public class Check_Completeness_of_a_Binary_Tree {
    // IDEA : DURING BFS, after a NULL node is seen....a NON-NULL node SHOULD NOT be seen
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode prev = root;
        while(q.size()>0)
        {
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                TreeNode curr = q.poll();
                
                if(prev == null && curr !=null) return false;
                if(curr == null) {prev = null;continue;}
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return true;
    }
}
