public class Maximum_Level_Sum_of_a_Binary_Tree
{
    // While doing BFS, keep track of a level's sum and update lvl if sum is greater.
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int level = 1, sum = 0, maxi = Integer.MIN_VALUE/2, finlvl = -1;
        while(!q.isEmpty())
        {
            TreeNode tmp = q.poll();
            
            if(tmp!=null)
            {
                sum+=tmp.val;
                if(tmp.left!=null)q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
            else
            {
                if(sum > maxi)
                {
                    maxi = sum;
                    finlvl = level;
                }
                level++;
                if(!q.isEmpty())q.offer(null);
                sum = 0;
            }
        }
        return finlvl;
    }
}