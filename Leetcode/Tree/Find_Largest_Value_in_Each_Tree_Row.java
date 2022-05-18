package Leetcode.Tree;

public class Find_Largest_Value_in_Each_Tree_Row {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int maxi = Integer.MIN_VALUE;
            for(int i = 0; i<size; i++)
            {
                TreeNode tmp = q.poll();
                maxi = Math.max(maxi, tmp.val);
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);    
            }
            res.add(maxi);
        }
        return res;
    }
}
