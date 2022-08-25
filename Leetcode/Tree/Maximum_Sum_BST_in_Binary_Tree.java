public class Maximum_Sum_BST_in_Binary_Tre
{
    // Processing from bottom to top is important for [mini, maxi]. Last sample case fails if we send
    // mini, maxi down the recursion
    // Rest of the problem si very similar to 
    class State
    {
        boolean isBST;
        int sum, mini, maxi;
        public State(boolean isBST, int sum, int mini, int maxi)
        {
            this.isBST = isBST;
            this.sum =sum;
            this.mini = mini;
            this.maxi = maxi;
        }
    }

    int maxSum;
    // Returns T/F, left
    public State dfs(TreeNode root)
    {
        if(root == null) return new State(true, 0, Integer.MAX_VALUE/2, Integer.MIN_VALUE/2);
        
        State left = dfs(root.left);
        State right = dfs(root.right);
        int leftMin = left.mini, leftMax = left.maxi;
        int rightMin = right.mini, rightMax = right.maxi;
        if(left.isBST && right.isBST && root.val > leftMax && root.val < rightMin)
        {
            int totSum = left.sum+right.sum+root.val;
            maxSum = Math.max(maxSum, totSum);
            return new State(true, totSum, Math.min(root.val,leftMin), Math.max(root.val, rightMax));
            
        }
        return new State(false, 0,0,0);
        
    }
    public int maxSumBST(TreeNode root) {
        maxSum = 0;
        dfs(root);
        return maxSum;
    }
}