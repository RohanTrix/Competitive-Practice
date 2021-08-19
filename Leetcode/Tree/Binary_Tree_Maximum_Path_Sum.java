/* IDEA:
 At each node, we find what is the max path sum we can get 
 from left and right. Incase, they are -ve, we put 0 as we dont take any node.
 The maxSum is now updated if best sum from left branch + best sum from right branch + 
 current node's value. We finally return the best ans to parent of current node by adding max(leftMax,rightMax)
 with current noe's value

*/

package Leetcode.Tree;
public class Binary_Tree_Maximum_Path_Sum
{
    int maxSum = Integer.MIN_VALUE;
    public int dfs(TreeNode root)
    {
        if(root==null) return 0;
        int leftMax = Math.max(0,dfs(root.left));
        int rightMax = Math.max(0,dfs(root.right));
        maxSum = Math.max(maxSum, leftMax + rightMax + root.val);
        return Math.max(leftMax, rightMax) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
}