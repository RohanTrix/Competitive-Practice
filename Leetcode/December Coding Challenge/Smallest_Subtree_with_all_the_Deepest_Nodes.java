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
class Solution {
    public ArrayList<TreeNode> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> last = new ArrayList<TreeNode>();
        while(!q.isEmpty())
        {
            TreeNode tmp = q.poll();
            if(tmp!=null)
            {
                curr.add(tmp);
                if(tmp.left!=null) q.offer(tmp.left);
                if(tmp.right!=null) q.offer(tmp.right);
            }
            else
            {
                last = new ArrayList<TreeNode>(curr);
                curr.clear();
                if(!q.isEmpty())
                {
                    q.offer(null);
                }
            }
        }
        return last;
    }
    public TreeNode LCA(TreeNode root, TreeNode a, TreeNode b)
    {
        if(root == null) return null;
        if(root ==a || root==b) return root;
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a , b);
        if( left!=null && right!=null) return root;
        if(left ==null && right ==null) return null;
        
        return (left!=null)? left: right;
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        ArrayList<TreeNode> deepNodes = levelOrder(root);
        TreeNode res = deepNodes.get(0);
        for(int i=0;i<deepNodes.size();i++)
            res = LCA(root,res, deepNodes.get(i));
        return res;
        
    }
}