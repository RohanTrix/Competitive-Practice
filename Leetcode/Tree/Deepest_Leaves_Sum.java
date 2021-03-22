package Leetcode.Tree;
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
public class Deepest_Leaves_Sum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        ArrayList<Integer> c_curr = new ArrayList<Integer>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty())
        {
            TreeNode tmp = q.poll();
            if(tmp!=null)
            {
                curr.add(tmp.val);
                if(tmp.left!=null)
                    q.offer(tmp.left);
                if(tmp.right!=null)
                    q.offer(tmp.right);
            }
            else
            {
                c_curr = new ArrayList<Integer>(curr);
                curr.clear();
                if(!q.isEmpty())
                    q.offer(null);
                
                   
            }
        }
        return c_curr.stream().mapToInt(Integer::intValue).sum();
    }
}
