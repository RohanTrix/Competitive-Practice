import java.util.*;

// Keep a track of the level and reverse curr list based on that
public class Binary_Tree_Zigzag_Level_Order_Traversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        int level = 0; // Keeps track of level
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> curr = new ArrayList<>();
        while(!q.isEmpty())
        {
            //System.out.println(q);
            TreeNode tmp = q.poll();
            if(tmp!=null)
            {
                curr.add(tmp.val);
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
                
            }
            else
            {
                if(level%2!=0) Collections.reverse(curr);
                res.add(new ArrayList<>(curr));
                curr.clear();
                
                if(!q.isEmpty())
                {
                    level++;
                    q.offer(null);
                }
            } 
        }
        return res;
    }
}