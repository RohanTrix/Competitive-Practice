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

class Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currNode = root;
        boolean done = false;
        while(!done)
        {
            if(currNode != null)
            {
                s.push(currNode);
                currNode = currNode.left;
            }
            else
            {
                if(s.isEmpty())
                    done = true;
                else
                {
                    currNode = s.pop();
                    res.add(currNode);
                    currNode = currNode.right;
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(TreeNode i: res)
            ans.add(i.val);
        return ans;
            
    }
}