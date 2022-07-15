public public boolean isEvenOddTree(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);
    int level = 1;
    while(q.size()>0)
    {
        int size = q.size();
        int prev = (level%2==0)?(int)1e9:(int)-1e9;
        for(int i = 0; i<size; i++)
        {
            TreeNode curr = q.poll();
            if(level%2 != curr.val%2)return false;
            if((level%2 == 0 && prev > curr.val) || (level%2 != 0 && prev < curr.val))
            {
                prev = curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            else return false;
        }
        level++;
    }
    return true;
} {
    
}
