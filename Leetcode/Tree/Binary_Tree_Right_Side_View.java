class Binary_Tree_Right_Side_View {
    // DFS APPROACH
    List<Integer> list = new ArrayList<>();
    public void dfs(TreeNode root, int dep)
    {
        if(root == null)
            return;
        if(list.size() == dep)
            list.add(root.val);
        dfs(root.right, dep+1);
        dfs(root.left, dep+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return list;
    }
}
class Binary_Tree_Right_Side_View1 {
    // BFS APPROACH
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i = 0; i<size; i++)
            {
                TreeNode curr = q.poll();
                if(i == 0)
                    list.add(curr.val);
                if(curr.right!=null) q.offer(curr.right);
                if(curr.left!=null) q.offer(curr.left);
            }
        }
        return list;
    }
}