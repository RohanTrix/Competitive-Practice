/**
 *      IDEA : This is a nice problem for DP.
 *              Since given array is the inorder traversal of tree leaves. Their order won't change.
 *              You can only decide which 2 consecutive nodes you wanna combine to 
 *              make a new node by their product. We need to basically apply paritioning type dp where
 *              we calculate the bestMinSum for left and right part and also retrieve the max leafs in
 *              the 2 subtrees. Hence for current node, we want to minimize the sums.
 */
public class Minimum_Cost_Tree_From_Leaf_Values {
    pair dp[][];
    public pair getMinSum(int l, int r, int nums[])
    {
        if(l == r)
            return new pair(0, nums[l]); // Non-leaf node sum =0 for leaf node
        
        if(dp[l][r]!=null) return dp[l][r];
        int mini = Integer.MAX_VALUE/2;
        int maxLeaf = -1;
        for(int p = l; p<r; p++) // We try to partition to get the min Possible trees of left and right side
        {
            pair left = getMinSum(l,p, nums);
            pair right = getMinSum(p+1, r, nums);
            if(left.sum + right.sum + (left.max*right.max) < mini) // If this is minimum, save sum and maxLeaf
            {
                mini = left.sum + right.sum + (left.max*right.max);
                maxLeaf = Math.max(left.max, right.max);
            }
        }
        return dp[l][r] = new pair(mini, maxLeaf);
    }
    public int mctFromLeafValues(int[] nums) {
        int n = nums.length;
        dp = new pair[n][n];
        return getMinSum(0,n-1, nums).sum;
    }
    private class pair
    {
        int sum, max;
        public pair(int sum, int max)
        {
            this.sum = sum;
            this.max = max;
        }
    }
}
