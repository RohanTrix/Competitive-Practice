/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;
class Average_of_Levels_in_Binary_Tree {
    public List<Double> averageOfLevels(TreeNode root) {
        ArrayList<Double> curr = new ArrayList<Double>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();;
        ArrayList<Double> res = new ArrayList<Double>();
        q.offer(root);
        q.offer(null);

        while(!q.isEmpty())
        {
            TreeNode tmp = q.poll();
            if(tmp == null)
            {
                double a = curr.stream().mapToDouble(c -> c).sum() / curr.size();
                res.add(a);
                curr.clear();
                if(!q.isEmpty()) q.offer(null);
                continue;
            }
            else
                curr.add((double)tmp.val);
            if(tmp.left!=null)
                q.offer(tmp.left);
            if(tmp.right!=null)
                q.offer(tmp.right);
            
        }
        return res;
    }
}